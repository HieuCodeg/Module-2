package md2.nmh.casestudy.views;

import md2.nmh.casestudy.manager.InputOption;
import md2.nmh.casestudy.manager.Role;
import md2.nmh.casestudy.manager.Teacher;
import md2.nmh.casestudy.services.FileUtil;
import md2.nmh.casestudy.services.InformationInput;
import md2.nmh.casestudy.statistic.TeacherList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TeacherMenu {
    public final static String PATH = "data/teacher.csv";
    public static Scanner sc = new Scanner(System.in);

    public static TeacherList teacherList = TeacherList.getInstance();

    public static void launch(Teacher teacherLogin) {
        int choosen = -1;
        do {
            Menu.showMenuTeacherManager();
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
                        ManagerView.showTeacher(teacherList.findAll(),teacherLogin);
                        break;
                    case 2:
                        teacherList.sortByName();
                        break;
                    case 3:
                        teacherList.sortByBirthday();
                        break;
                    case 4:
                        teacherList.sortByClass();
                        break;
                    case 5:
                        findTeacherByName();
                        break;
                    case 6:
                        editTeacher(teacherLogin);
                        break;
                    case 7:
                        if (teacherLogin.getRole().equals(Role.ADMIN)) {
                            deleteTeacher();
                        } else {
                            System.out.println("Bạn không có quyền truy cập!!!");
                        }
                        break;
                    case 8:
                        if (teacherLogin.getRole().equals(Role.ADMIN)) {
                            addTeacher();
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
                System.out.println("Nhập sai !!!");
            }
        } while (choosen != 0);
    }

    private static void findTeacherByName() {
        System.out.println("Nhập tên giáo viên:");
        String name = sc.nextLine();
        name = name.trim();
        if (!teacherList.existByName(name)) {
            System.out.println("Không tìm thấy giáo viên");
            return;
        }
        System.out.printf("%-10s %-26s %-10s %-15s %-10s %-10s %-15s %-15s %-10s\n",
                "Id", "Tên", "Giới tính", "Ngày sinh", "Lớp", "Môn học", "Tên đăng nhập", "Mật khẩu", "Role");

        for (Teacher teacher : teacherList.findAll()) {
            if (teacher.getName().toUpperCase().equals(name.toUpperCase())) {
                ManagerView.showTeacher(teacher);
            }
        }


    }


    private static void addTeacher() {
        Teacher newTeacher = new Teacher();
        newTeacher.setName(InformationInput.inputName(InputOption.ADD));
        newTeacher.setGender(InformationInput.inputGender());
        newTeacher.setBirthday(InformationInput.inputBirthday(InputOption.ADD));
        newTeacher.setClassed(InformationInput.inputClass(InputOption.ADD));
        newTeacher.setSubject(InformationInput.inputSubject());
        newTeacher.setUsername(InformationInput.inputUsername());
        newTeacher.setPassword(InformationInput.inputPassword());
        newTeacher.setRole(InformationInput.inputRole());
        teacherList.add(newTeacher);
        System.out.println("Thêm giáo viên " + newTeacher.getName() + " thành công !!!");
    }

    private static void deleteTeacher() {
        System.out.println("Nhập id giáo viên cần xóa");
        int id = -1;
        try {
            id = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (id < 0 || !teacherList.existsById(id)) {
            System.out.println("Không tìm thấy giáo viên");
            return;
        }
        Teacher teacher = teacherList.getById(id);
        ManagerView.showOnlyTeacher(teacher);
        System.out.println("Bạn chắc chắn muốn xóa giáo viên này?");

        System.out.println("1. Đồng ý");
        System.out.println("2. Hủy (Or eny key)");

        String choosen = sc.nextLine();

        if (choosen.equals("1")) {
            System.out.println("Đã xóa giáo viên: " + teacher.getName());
            teacherList.remove(teacher);
        } else {
            System.out.println("Hủy thành công!!!");
        }
}

    private static void editTeacher(Teacher teacherLogin) {

        if (teacherLogin.getRole().equals(Role.USER)) {
            selectionEdit(teacherLogin,teacherLogin);
        } else {
            System.out.println("Nhập id giáo viên cần sửa: ");

            int    id = Integer.parseInt(sc.nextLine());

            if (id < 0 || !teacherList.existsById(id)) {
                System.out.println("Không tìm thấy giáo viên !!!");
                return;
            }
            Teacher teacher = teacherList.getById(id);
            ManagerView.showOnlyTeacher(teacher);

            selectionEdit(teacherLogin,teacher);
        }
    }

    private static void selectionEdit(Teacher teacherLogin,Teacher teacher) {
        int choosen = -1;
        do {
            Menu.showMenuEditTeacher();
            try {
                do {
                    System.out.println("Chọn chức năng: ");
                    System.out.print(" ☞   ");
                    choosen = Integer.parseInt(sc.nextLine());
                    if (choosen > 9 || choosen < 0)
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại !!!");
                } while (choosen > 9 || choosen < 0);
                switch (choosen) {
                    case 1:
                        teacherList.remove(teacher);
                        teacher.setName(InformationInput.inputName(InputOption.UPDATE));
                        teacherList.add(teacher);
                        System.out.println("☑ Sửa thành công !!! ");

                        return;
                    case 2:
                        teacherList.remove(teacher);
                        teacher.setGender(InformationInput.inputGender());
                        teacherList.add(teacher);
                        System.out.println("☑ Sửa thành công !!! ");

                        return;
                    case 3:
                        teacherList.remove(teacher);
                        teacher.setBirthday(InformationInput.inputBirthday(InputOption.UPDATE));
                        teacherList.add(teacher);
                        System.out.println("☑ Sửa thành công !!! ");

                        return;
                    case 4:
                        teacherList.remove(teacher);
                        teacher.setClassed(InformationInput.inputClass(InputOption.UPDATE));
                        teacherList.add(teacher);
                        System.out.println("☑ Sửa thành công !!! ");

                        return;
                    case 5:
                        teacherList.remove(teacher);
                        teacher.setSubject(InformationInput.inputSubject());
                        teacherList.add(teacher);
                        System.out.println("☑ Sửa thành công !!! ");

                        return;
                    case 6:
                        teacherList.remove(teacher);
                        teacher.setUsername(InformationInput.inputUsername());
                        teacherList.add(teacher);
                        System.out.println("☑ Sửa thành công !!! ");

                        return;
                    case 7:
                        teacherList.remove(teacher);
                        teacher.setPassword(InformationInput.inputPassword());
                        teacherList.add(teacher);
                        System.out.println("☑ Sửa thành công !!! ");

                        return;
                    case 8:
                        if (teacherLogin.getRole().equals(Role.ADMIN)) {
                            teacherList.remove(teacher);
                            teacher.setRole(InformationInput.inputRole());
                            teacherList.add(teacher);
                            System.out.println("☑ Sửa thành công !!! ");
                        } else {
                            System.out.println("Bạn không có quyền truy cập!!!");
                        }
                        return;
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
}
