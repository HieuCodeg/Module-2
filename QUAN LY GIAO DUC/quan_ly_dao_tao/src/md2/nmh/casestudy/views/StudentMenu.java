package md2.nmh.casestudy.views;

import md2.nmh.casestudy.manager.InputOption;
import md2.nmh.casestudy.manager.Role;
import md2.nmh.casestudy.manager.Student;
import md2.nmh.casestudy.manager.Teacher;
import md2.nmh.casestudy.services.AppUtils;
import md2.nmh.casestudy.services.InformationInput;
import md2.nmh.casestudy.statistic.StudentsList;

import java.util.*;

public class StudentMenu {
    public static Scanner sc = new Scanner(System.in);
    public static StudentsList studentsList = StudentsList.getInstance();

    public static void launch(Teacher teacherLogin) {
        int choosen = -1;
        do {
            Menu.showMenuStudentManager();
            try {
                do {
                    System.out.println("Chọn chức năng: ");
                    System.out.print(" ☞ ");
                    choosen = Integer.parseInt(sc.nextLine());
                    if (choosen > 9 || choosen < 0)
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                } while (choosen > 9 || choosen < 0);
                switch (choosen) {
                    case 1:
                        ManagerView.showStudent(studentsList.findAll());
                        AppUtils.step();
                        break;
                    case 2:
                        studentsList.sortByName();
                        AppUtils.step();
                        break;
                    case 3:
                        studentsList.sortByBirthday();
                        AppUtils.step();
                        break;
                    case 4:
                        studentsList.sortByClass();
                        AppUtils.step();
                        break;
                    case 5:
                        findStudentByName();
                        AppUtils.step();
                        break;
                    case 6:
                        editStudent(teacherLogin);
                        break;
                    case 7:
                        if (teacherLogin.getRole().equals(Role.ADMIN)) {
                            deleteStudent();
                        } else {
                            System.out.println("Bạn không có quyền truy cập!!!");
                        }
                        break;
                    case 8:
                        if (teacherLogin.getRole().equals(Role.ADMIN)) {
                            addStudent();
                        } else {
                            System.out.println("Bạn không có quyền truy cập!!!");
                        }
                        break;
                    case 9:
                        return;
                    case 0:
                        ManagerView.exit();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        } while (choosen != 0);
    }

    private static void show() {
        ;
    }

    private static void findStudentByName() {
        System.out.println("Nhập tên học sinh:");
        String name = sc.nextLine();
        name = name.trim();
        if (!studentsList.existByName(name)) {
            System.out.println("Không tìm thấy học sinh");
            return;
        }
        System.out.printf("%-5s %-5s %-19s %-21s %-1s %-9s %-1s %-10s %-4s %-13s %-16s %-20s %-2s %-5s %-1s\n",
                "┃", "ID", "│", "TÊN", "│", "GIỚI TÍNH", "│", "NGÀY SINH", "│", "ĐIỆN THOẠI", "│", "EMAIL", "│", "LỚP", "┃");

        for (Student student : studentsList.findAll()) {
            if (student.getName().toUpperCase().equals(name.toUpperCase())) {
                ManagerView.showStudent(student);
            }
        }

    }

    private static void addStudent() {
        Student newStudent = new Student();
        newStudent.setName(InformationInput.inputName(InputOption.ADD));
        newStudent.setGender(InformationInput.inputGender());
        newStudent.setBirthday(InformationInput.inputBirthday(InputOption.ADD));
        newStudent.setPhoneNumber(InformationInput.inputPhoneNumber(InputOption.ADD));
        newStudent.setEmail(InformationInput.inputEmail(InputOption.ADD));
        newStudent.setClassed(InformationInput.inputClass(InputOption.ADD));
        studentsList.add(newStudent);
        System.out.println("Thêm học sinh thành công !!!");
    }

    private static void deleteStudent() {
        System.out.println("Nhập id học sinh cần xóa");
        int id = -1;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (id < 0 || !studentsList.existsById(id)) {
            System.out.println("Không tìm thấy học sinh");
            return;
        }

        Student student = studentsList.getById(id);
        ManagerView.showOnlyStudent(student);

        System.out.println("Bạn chắc chắn muốn xóa học sinh?");
        System.out.println("1. Đồng ý");
        System.out.println("2. Hủy (Or eny key)");

        String choosen = sc.nextLine();

        if (choosen.equals("1")) {
            System.out.println("Đã xóa học sinh: " + student.getName());
            studentsList.remove(student);
        } else {
            System.out.println("Hủy thành công!!!");
        }

    }

    private static void editStudent(Teacher teacherLogin) {
        System.out.println("Nhập id học sinh cần sửa");
        int id = -1;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (id < 0 || !studentsList.existsById(id)) {
            System.out.println("Không tìm thấy học sinh");
            return;
        }

        Student student = studentsList.getById(id);
        if (!student.getClassed().equals(teacherLogin.getClassed())) {
            System.out.println("Bạn chỉ có quyền sửa thông tin học sinh lớp mình!!!");
            return;
        }
        ManagerView.showOnlyStudent(student);
        selectionEdit(student);

    }

    private static void selectionEdit(Student student) {
        int choosen = -1;
        do {
            Menu.showMenuEdit();
            try {
                do {
                    System.out.println("Chọn chức năng: ");
                    System.out.print(" ☞ ");
                    choosen = Integer.parseInt(sc.nextLine());
                    if (choosen > 7 || choosen < 0)
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                } while (choosen > 7 || choosen < 0);
                switch (choosen) {
                    case 1:
                        studentsList.remove(student);
                        student.setName(InformationInput.inputName(InputOption.UPDATE));
                        studentsList.add(student);
                        System.out.println("☑ Sửa thành công !!! ");
                        break;
                    case 2:
                        studentsList.remove(student);
                        student.setGender(InformationInput.inputGender());
                        studentsList.add(student);
                        System.out.println("☑ Sửa thành công !!! ");
                        break;
                    case 3:
                        studentsList.remove(student);
                        student.setBirthday(InformationInput.inputBirthday(InputOption.UPDATE));
                        studentsList.add(student);
                        System.out.println("☑ Sửa thành công !!! ");
                        break;
                    case 4:
                        studentsList.remove(student);
                        student.setPhoneNumber(InformationInput.inputPhoneNumber(InputOption.UPDATE));
                        studentsList.add(student);
                        System.out.println("☑ Sửa thành công !!! ");
                        break;
                    case 5:
                        studentsList.remove(student);
                        student.setEmail(InformationInput.inputEmail(InputOption.UPDATE));
                        studentsList.add(student);
                        System.out.println("☑ Sửa thành công !!! ");
                        break;
                    case 6:
                        studentsList.remove(student);
                        student.setClassed(InformationInput.inputClass(InputOption.UPDATE));
                        studentsList.add(student);
                        System.out.println("☑ Sửa thành công !!! ");
                        break;
                    case 7:
                        return;
                    case 0:
                        ManagerView.exit();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        } while (choosen != 0);

    }

}
