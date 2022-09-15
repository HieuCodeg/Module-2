package md2.nmh.casestudy.views;

import md2.nmh.casestudy.manager.*;
import md2.nmh.casestudy.services.FileUtil;
import md2.nmh.casestudy.services.InformationInput;
import md2.nmh.casestudy.services.ScoreUtil;
import md2.nmh.casestudy.statistic.ClassList;
import md2.nmh.casestudy.statistic.StudentsList;

import java.util.*;

public class ClassMenu {
    public final static String PATH = "data/score.csv";
//    Khởi tạo danh sách các lớp + thêm học sinh vào lớp
    public static ClassList classList = ClassList.getInstance();
    static Map<String, Classed> classedMap = classList.findAll();

    static Scanner sc = new Scanner(System.in);

    public static void launch(String name, Teacher teacherLogin) {
        Classed classed = classedMap.get(name);
        int choosen = -1;
        do {
            showMenuOption();
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
                        show(classList.findAll().get(name));
                        break;
                    case 2:
                        sortByName(classList.findAll().get(name).getStudentslist());
                        break;
                    case 3:
                        sortByBirthday(classList.findAll().get(name).getStudentslist());
                        break;
                    case 4:
                        sortById(classList.findAll().get(name).getStudentslist());
                        break;
                    case 5:
                        ManagerView.showStudentScore(classList.findAll().get(name).getStudentslist());
                        break;
                    case 6:
                        findStudentScore(classList.findAll().get(name).getStudentslist());
                        break;
                    case 7:
                        if (teacherLogin.getRole().equals(Role.ADMIN) || teacherLogin.getClassed().equals(name)) {
                            editStudentScore(classList.findAll().get(name).getStudentslist());
                        } else {
                            System.out.println("Bạn không có quyền truy cập!!!");
                        }

                        break;
                    case 8:
                        if (teacherLogin.getRole().equals(Role.ADMIN) || teacherLogin.getClassed().equals(name)) {
                            addStudentScore(classList.findAll().get(name).getStudentslist());
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
            } catch (InputMismatchException e) {
                System.err.println("Nhập sai! vui lòng nhập lại");
            }
            catch (Exception e){
            }
        } while (choosen != 0);
    }

    private static Student findStudentScore(List<Student> students) {
        long id = 0;
        while (true) {
            try {
                System.out.println("Nhập id học sinh");
                id = Long.parseLong(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        }
        for (Student student : students) {
            if (student.getId() == id) {
                ManagerView.showStudentTableScore(student);
                return student;
            }
        }
        System.out.println("Không tìm thấy học sinh! Vui lòng kiểm tra lại!");
        return null;
    }

    private static void sortById(List<Student> studentList) {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o1.getId() - (o2.getId()));
            }
        });
        System.out.println("Sắp xếp xong!");
    }

    private static void sortByBirthday(List<Student> studentList) {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getBirthday().compareTo(o1.getBirthday());
            }
        });
        System.out.println("Sắp xếp xong!");
    }

    private static void sortByName(List<Student> studentList) {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        System.out.println("Sắp xếp xong!");
    }

    private static void show(Classed classed) {
        System.out.println("┍─────────────────────────────────────────────────────────────〘      DANH SÁCH LỚP       〙──────────────────────────────────────────────────────────────┑");
//        System.out.println("┃------------------------------------------------------------------------------------------------------------------------------------------------┃");
        System.out.printf("%-8s %-143s %-1s\n","┃","Lớp: " + classed.getName(),"┃");
        System.out.printf("%-8s %-143s %-1s\n","┃","Sĩ số: " + classed.getName(),"┃");
        System.out.printf("%-8s %-143s %-1s\n","┃","Giáo viên chủ nhiệm: " + classed.getHeadTeacher(),"┃");
//        System.out.println("        LỚP " + classed.getName());
//        System.out.println("        Sĩ số: " + classed.getTotal());
//        System.out.println("        Giáo viên chủ nhiệm: " + classed.getHeadTeacher());
        ManagerView.showStudent(classed.getStudentslist());
    }

    private static Student findStudentById(List<Student> students) {
        long id = 0;
        while (true) {
            try {
                System.out.println("Nhập id học sinh");
                id = Long.parseLong(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        }
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    private static void editStudentScore(List<Student> students) {
        Student student = findStudentById(students);
        if (student == null) {
            System.out.println("Không tìm thấy học sinh! Vui lòng kiểm tra lại!");
            return;
        }
        showMenuSubject(InputOption.UPDATE, student);
    }

    private static void addStudentScore(List<Student> students) {
        Student student = findStudentById(students);
        if (student == null) {
            System.out.println("Không tìm thấy học sinh! Vui lòng kiểm tra lại!");
            return;
        }
        showMenuSubject(InputOption.ADD, student);

    }

    private static void showMenuSubject(InputOption option, Student student) {
        int choosen = -1;
        do {
            showMenuEditSubject();

                do {
                    if (option.equals(InputOption.UPDATE)) {
                        System.out.println("Chọn môn học cần sửa điểm: ");
                    } else {
                        System.out.println("Chọn môn học nhập điểm: ");
                    }
                    System.out.print(" ☞ ");
                    choosen = Integer.parseInt(sc.nextLine());
                    if (choosen > 9 || choosen < 0)
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                } while (choosen > 9 || choosen < 0);
                switch (choosen) {
                    case 1:
                        showMenuSemester(option, student, Subject.ANH);
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 2:
                        showMenuSemester(option, student, Subject.HOA);
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 3:
                        showMenuSemester(option, student, Subject.SU);
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 4:
                        showMenuSemester(option, student, Subject.VAN);
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 5:
                        showMenuSemester(option, student, Subject.SINH);
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 6:
                        showMenuSemester(option, student, Subject.TIN);
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 7:
                        showMenuSemester(option, student, Subject.TOAN);
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 8:
                        showMenuSemester(option, student, Subject.LY);
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 9:
                        return;
                    case 0:
                        ManagerView.exit();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }

        } while (choosen != 0);
    }

    private static void showMenuSemester(InputOption option, Student student, Subject subject) {
        int choosen = -1;
        do {
            showMenuEditSemester();

                do {
                    if (option.equals(InputOption.UPDATE)) {
                        System.out.println("Chọn học kì cần sửa: ");
                    } else {
                        System.out.println("Chọn học kì nhập điểm: ");
                    }
                    System.out.print(" ☞ ");
                    choosen = Integer.parseInt(sc.nextLine());
                    if (choosen > 3 || choosen < 0)
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                } while (choosen > 3 || choosen < 0);
                switch (choosen) {
                    case 1:
                        showMenuScore(option, student, subject, "HK1");
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 2:
                        showMenuScore(option, student, subject, "HK2");
                        if (option.equals(InputOption.UPDATE)) {
                            return;
                        } else {
                            break;
                        }
                    case 3:
                        return;
                    case 0:
                        ManagerView.exit();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }
        } while (choosen != 0);
    }

    private static void showMenuScore(InputOption option, Student student, Subject subject, String semester) {
        int choosen = -1;
        do {
            showMenuEditScore();

                do {
                    if (option.equals(InputOption.UPDATE)) {
                        System.out.println("Chọn mục sửa: ");
                    } else {
                        System.out.println("Chọn mục nhập điểm: ");
                    }
                    System.out.print(" ☞ ");
                    choosen = Integer.parseInt(sc.nextLine());
                    if (choosen > 5 || choosen < 0)
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                } while (choosen > 5 || choosen < 0);
                switch (choosen) {
                    case 1:
                        if (option.equals(InputOption.UPDATE)) {
                            editScore(student, subject, semester, "Điểm miệng");
                            return;
                        } else {
                            addScore(student, subject, semester, "Điểm miệng");
                            break;
                        }
                    case 2:

                        if (option.equals(InputOption.UPDATE)) {
                            editScore(student, subject, semester, "Điểm 15 phút");
                            return;
                        } else {
                            addScore(student, subject, semester, "Điểm 15 phút");
                            break;
                        }
                    case 3:

                        if (option.equals(InputOption.UPDATE)) {
                            editScore(student, subject, semester, "Điểm 1 tiết");
                            return;
                        } else {
                            addScore(student, subject, semester, "Điểm 1 tiết");
                            break;
                        }
                    case 4:

                        if (option.equals(InputOption.UPDATE)) {
                            editScore(student, subject, semester, "Điểm học kỳ");
                            return;
                        } else {
                            addScore(student, subject, semester, "Điểm học kỳ");
                            break;
                        }
                    case 5:
                        return;
                    case 0:
                        ManagerView.exit();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        break;
                }

        } while (choosen != 0);
    }

    private static void editScore(Student student, Subject subject, String semester, String score) {
        List<Student> students;
        switch (semester) {
            case "HK1":
                switch (score) {
                    case "Điểm miệng":
                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.print("Điểm miệng hiện tại: ");
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().getMouthScore());

                            students = StudentsList.getInstance().findAll();
                            for (int i = 0; i <students.size(); i++) {
                                if (students.get(i).getId() == student.getId()) {
                                    students.get(i).getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().setMouthScore(InformationInput.inputListNumberScore());
                                    break;
                                }
                            }
                            FileUtil.writeScore(PATH,students);
                            System.out.println("Sửa hoàn thành !!!");
                        } else {
                            System.out.println("chưa có điểm !!!");
                        }

                        return;
                    case "Điểm 15 phút":

                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.print("Điểm 15 phút hiện tại: ");
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().getFifteenScore());

                            students = StudentsList.getInstance().findAll();
                            for (int i = 0; i <students.size(); i++) {
                                if (students.get(i).getId() == student.getId()) {
                                    students.get(i).getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().setFifteenScore(InformationInput.inputListNumberScore());
                                    break;
                                }
                            }
                            FileUtil.writeScore(PATH,students);
                            System.out.println("Sửa hoàn thành !!!");
                        } else {
                            System.out.println("chưa có điểm !!!");
                        }

                        return;
                    case "Điểm 1 tiết":

                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.print("Điểm 1 tiết hiện tại: ");
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().getOneLessonScore());

                            students = StudentsList.getInstance().findAll();
                            for (int i = 0; i <students.size(); i++) {
                                if (students.get(i).getId() == student.getId()) {
                                    students.get(i).getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().setOneLessonScore(InformationInput.inputListNumberScore());
                                    break;
                                }
                            }
                            FileUtil.writeScore(PATH,students);
                            System.out.println("Sửa hoàn thành !!!");
                        } else {
                            System.out.println("chưa có điểm !!!");
                        }

                        return;
                    case "Điểm học kỳ":

                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.print("Điểm học kỳ I hiện tại: ");
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().getSemesterScore());

                            students = StudentsList.getInstance().findAll();
                            for (int i = 0; i <students.size(); i++) {
                                if (students.get(i).getId() == student.getId()) {
                                    students.get(i).getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().setSemesterScore(InformationInput.inputScore());
                                    break;
                                }
                            }
                            FileUtil.writeScore(PATH,students);
                            System.out.println("Sửa hoàn thành !!!");
                        } else {
                            System.out.println("chưa có điểm !!!");
                        }

                        return;
                }
                break;
            case "HK2":
                switch (score) {
                    case "Điểm miệng":

                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.print("Điểm miệng hiện tại: ");
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().getMouthScore());

                            students = StudentsList.getInstance().findAll();
                            for (int i = 0; i <students.size(); i++) {
                                if (students.get(i).getId() == student.getId()) {
                                    students.get(i).getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().setMouthScore(InformationInput.inputListNumberScore());
                                    break;
                                }
                            }
                            FileUtil.writeScore(PATH,students);
                            System.out.println("Sửa hoàn thành !!!");
                        } else {
                            System.out.println("chưa có điểm !!!");
                        }

                        return;
                    case "Điểm 15 phút":

                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.print("Điểm 15 phút hiện tại: ");
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().getFifteenScore());

                            students = StudentsList.getInstance().findAll();
                            for (int i = 0; i <students.size(); i++) {
                                if (students.get(i).getId() == student.getId()) {
                                    students.get(i).getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().setFifteenScore(InformationInput.inputListNumberScore());
                                    break;
                                }
                            }
                            FileUtil.writeScore(PATH,students);
                            System.out.println("Sửa hoàn thành !!!");
                        } else {
                            System.out.println("chưa có điểm !!!");
                        }

                        return;
                    case "Điểm 1 tiết":

                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.print("Điểm 1 tiết hiện tại: ");
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().getOneLessonScore());

                            students = StudentsList.getInstance().findAll();
                            for (int i = 0; i <students.size(); i++) {
                                if (students.get(i).getId() == student.getId()) {
                                    students.get(i).getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().setOneLessonScore(InformationInput.inputListNumberScore());
                                    break;
                                }
                            }
                            FileUtil.writeScore(PATH,students);
                            System.out.println("Sửa hoàn thành !!!");
                        } else {
                            System.out.println("chưa có điểm !!!");
                        }

                        return;
                    case "Điểm học kỳ":

                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.print("Điểm học kỳ II hiện tại: ");
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().getSemesterScore());

                            students = StudentsList.getInstance().findAll();
                            for (int i = 0; i <students.size(); i++) {
                                if (students.get(i).getId() == student.getId()) {
                                    students.get(i).getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().setSemesterScore(InformationInput.inputScore());
                                    break;
                                }
                            }
                            FileUtil.writeScore(PATH,students);
                            System.out.println("Sửa hoàn thành !!!");
                        } else {
                            System.out.println("chưa có điểm !!!");
                        }

                        return;
                }
                break;
        }

    }

    private static void addScore(Student student, Subject subject, String semester, String score) {
        ArrayList<String> list;
        String line;
        List<Student> students;
        if (!student.getScoreStudent().containSubject(subject.getValue())) {
            list = new ArrayList<>();
            list.add(subject.getValue());
        } else {
            list = student.getScoreStudent().getScoreSubject(subject.getValue()).getScoreSubjectList();
        }
        switch (semester) {
            case "HK1":
                switch (score) {
                    case "Điểm miệng":
                        System.out.print("Điểm miệng hiện tại: ");
                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().getMouthScore());
                        } else {
                            System.out.println("chưa có!");
                        }

                        ArrayList<String> mouthList = InformationInput.inputListStringScore();
                        addList(list,semester,"a",mouthList);
                        line = list.toString();
                        line = line.substring(1,line.length() -1);
                        ScoreSubject scoreSubject = ScoreUtil.parseScore(line);

                        students = StudentsList.getInstance().findAll();
                        for (int i = 0; i <students.size(); i++) {
                            if (students.get(i).getId() == student.getId()) {
                                students.get(i).getScoreStudent().setSubjectScore(scoreSubject);
                                break;
                            }
                        }
                        FileUtil.writeScore(PATH,students);

                        System.out.println("Thêm thành công !!!");
                        break;
                    case "Điểm 15 phút":
                        System.out.print("Điểm 15 phút hiện tại: ");
                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().getFifteenScore());
                        } else {
                            System.out.println("chưa có!");
                        }

                        ArrayList<String> fifteenList = InformationInput.inputListStringScore();
                        addList(list,semester,"b",fifteenList);
                        line = list.toString();
                        line = line.substring(1,line.length() -1);

                        students = StudentsList.getInstance().findAll();
                        for (int i = 0; i <students.size(); i++) {
                            if (students.get(i).getId() == student.getId()) {
                                students.get(i).getScoreStudent().setSubjectScore(ScoreUtil.parseScore(line));
                                break;
                            }
                        }
                        FileUtil.writeScore(PATH,students);
//                        student.getScoreStudent().setSubjectScore(ScoreUtil.parseScore(line));
                        System.out.println("Thêm thành công !!!");
                        break;
                    case "Điểm 1 tiết":
                        System.out.print("Điểm 1 tiết hiện tại: ");
                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().getOneLessonScore());
                        } else {
                            System.out.println("chưa có!");
                        }

                        ArrayList<String> oneLessonList = InformationInput.inputListStringScore();
                        addList(list,semester,"c",oneLessonList);
                        line = list.toString();
                        line = line.substring(1,line.length() -1);
                        students = StudentsList.getInstance().findAll();
                        for (int i = 0; i <students.size(); i++) {
                            if (students.get(i).getId() == student.getId()) {
                                students.get(i).getScoreStudent().setSubjectScore(ScoreUtil.parseScore(line));
                                break;
                            }
                        }

                        System.out.println("Thêm thành công !!!");
                        break;
                    case "Điểm học kỳ":
                        System.out.print("Điểm học kỳ I hiện tại: ");
                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterOne().getSemesterScore());
                        } else {
                            System.out.println("chưa có!");
                        }

                        ArrayList<String> semesterList = new ArrayList<>();
                        semesterList.add(String.valueOf(InformationInput.inputScore()));
                        addList(list,semester,"d",semesterList);
                        line = list.toString();
                        line = line.substring(1,line.length() -1);

                        students = StudentsList.getInstance().findAll();
                        for (int i = 0; i <students.size(); i++) {
                            if (students.get(i).getId() == student.getId()) {
                                students.get(i).getScoreStudent().setSubjectScore(ScoreUtil.parseScore(line));
                                break;
                            }
                        }

                        System.out.println("Thêm thành công !!!");
                        break;
                }
                break;
            case "HK2":
                switch (score) {
                    case "Điểm miệng":
                        System.out.print("Điểm miệng hiện tại: ");
                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().getMouthScore());
                        } else {
                            System.out.println("chưa có!");
                        }

                        ArrayList<String> mouthList = InformationInput.inputListStringScore();
                        addList(list,semester,"a",mouthList);
                        line = list.toString();
                        line = line.substring(1,line.length() -1);

                        students = StudentsList.getInstance().findAll();
                        for (int i = 0; i <students.size(); i++) {
                            if (students.get(i).getId() == student.getId()) {
                                students.get(i).getScoreStudent().setSubjectScore(ScoreUtil.parseScore(line));
                                break;
                            }
                        }

                        System.out.println("Thêm thành công !!!");
                        break;
                    case "Điểm 15 phút":
                        System.out.print("Điểm 15 phút hiện tại: ");
                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().getFifteenScore());
                        } else {
                            System.out.println("chưa có!");
                        }

                        ArrayList<String> fifteenList = InformationInput.inputListStringScore();
                        addList(list,semester,"b",fifteenList);
                        line = list.toString();
                        line = line.substring(1,line.length() -1);

                        students = StudentsList.getInstance().findAll();
                        for (int i = 0; i <students.size(); i++) {
                            if (students.get(i).getId() == student.getId()) {
                                students.get(i).getScoreStudent().setSubjectScore(ScoreUtil.parseScore(line));
                                break;
                            }
                        }

                        System.out.println("Thêm thành công !!!");
                        break;
                    case "Điểm 1 tiết":
                        System.out.print("Điểm 1 tiết hiện tại: ");
                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().getOneLessonScore());
                        } else {
                            System.out.println("chưa có!");
                        }

                        ArrayList<String> oneLessonList = InformationInput.inputListStringScore();
                        addList(list,semester,"c",oneLessonList);
                        line = list.toString();
                        line = line.substring(1,line.length() -1);

                        students = StudentsList.getInstance().findAll();
                        for (int i = 0; i <students.size(); i++) {
                            if (students.get(i).getId() == student.getId()) {
                                students.get(i).getScoreStudent().setSubjectScore(ScoreUtil.parseScore(line));
                                break;
                            }
                        }

                        System.out.println("Thêm thành công !!!");
                        break;
                    case "Điểm học kỳ":
                        System.out.print("Điểm học kỳ II hiện tại: ");
                        if (student.getScoreStudent().containSubject(subject.getValue())) {
                            System.out.println(student.getScoreStudent().getScoreSubject(subject.getValue()).getSemesterTwo().getSemesterScore());
                        } else {
                            System.out.println("chưa có!");
                        }

                        ArrayList<String> semesterList = new ArrayList<>();
                        semesterList.add(String.valueOf(InformationInput.inputScore()));
                        addList(list,semester,"d",semesterList);
                        line = list.toString();
                        line = line.substring(1,line.length() -1);

                        students = StudentsList.getInstance().findAll();
                        for (int i = 0; i <students.size(); i++) {
                            if (students.get(i).getId() == student.getId()) {
                                students.get(i).getScoreStudent().setSubjectScore(ScoreUtil.parseScore(line));
                                break;
                            }
                        }

                        System.out.println("Thêm thành công !!!");
                        break;
                }
                break;
        }

    }

    public static void addList(List<String> list, String semester, String key, List<String> value) {
        switch (semester) {
            case "HK1":
                if (!list.contains(semester)) {
                    list.add(1, semester);
                    list.add(2,key);
                    list.addAll(3, value);
                    return;
                }
                int endIndex = 0;
                while (endIndex < list.size() && list.get(endIndex) != "HK2") {
                    endIndex++;
                }
//    Lịch sử,HK1,a,8,9,b,9,c,7,7,6,d,6.6,HK2,a,8,9,b,9,c,7.4

                ArrayList<String> semester1List = new ArrayList<>();
                for (int i = 2; i < endIndex; i++) {
                    semester1List.add(list.get(2));
                    list.remove(2);
                }
//                Trường hợp đã có mục điểm
                if (semester1List.contains(key)) {
                    int index = 0;
                    for (int i = 0; i < semester1List.size(); i++) {
                        if (semester1List.get(i) == key) {
                            index = i;
                            break;
                        }
                    }
                    do {
                        index++;
                        if (index >= semester1List.size()) {
                            break;
                        }
                    } while (ScoreUtil.isNumber(semester1List.get(index)));
                    semester1List.addAll(index, value);
                    list.addAll(2, semester1List);
                    return;
                }
//                 Trường hợp chưa có mục điểm
                switch (key) {
                    case "a":
                        semester1List.add(0, "a");
                        semester1List.addAll(1, value);
                        break;
                    case "b":
                        if (semester1List.get(0) == "c" || semester1List.get(0) == "d") {
                            semester1List.add(0, "b");
                            semester1List.addAll(1, value);
                            break;
                        }
                        int index = 0;
                        do {
                            index++;
                            if (index >= semester1List.size()) {
                                break;
                            }
                        } while (ScoreUtil.isNumber(semester1List.get(index)));
                        semester1List.addAll(index, value);
                        semester1List.add(index, "b");
                        break;
                    case "c":
                        if (!semester1List.contains("d")) {
                            semester1List.add(semester1List.size(),"c");
                            semester1List.addAll(semester1List.size(),value);
                            break;
                        }
                        int indexd = 0;
                        for (int i = 0; i < semester1List.size(); i++) {
                            if (semester1List.get(i) == "d") {
                                indexd = i;
                                break;
                            }
                        }
                        semester1List.addAll(indexd,value);
                        semester1List.add(indexd,"c");
                        break;
                    case "d":
                        semester1List.add(semester1List.size(),"d");
                        semester1List.addAll(semester1List.size(),value);
                        break;
                }
                list.addAll(2, semester1List);
                break;
            case "HK2":
                if (!list.contains(semester)) {
                    list.add(semester);
                    list.add(key);
                    list.addAll(value);
                    return;
                }
                int beginIndex = 0;
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i) == "HK2") {
                        beginIndex = i +1;
                        break;
                    }
                }
//    Lịch sử,HK1,a,8,9,b,9,c,7,7,6,d,6.6,HK2,a,8,9,b,9,c,7

                ArrayList<String> semester2List = new ArrayList<>();
                int size = list.size();
                for (int i = beginIndex; i < size; i++) {
                    semester2List.add(list.get(beginIndex));
                    list.remove(beginIndex);
                }
//                Trường hợp đã có mục điểm

                if (semester2List.contains(key)) {
                    int index = 0;
                    for (int i = 0; i < semester2List.size(); i++) {
                        if (semester2List.get(i) == key) {
                            index = i;
                            break;
                        }
                    }
                    do {
                        index++;
                        if (index >= semester2List.size()) {
                            break;
                        }
                    } while (ScoreUtil.isNumber(semester2List.get(index)));
                    semester2List.addAll(index, value);
                    list.addAll(beginIndex, semester2List);
                    return;
                }
//                 Trường hợp chưa có mục điểm
                //                a,8,9,b,9,c,7,7,6,d,6
                switch (key) {
                    case "a":
                        semester2List.add(0, "a");
                        semester2List.addAll(1, value);
                        break;
                    case "b":
                        if (semester2List.get(0) == "c" || semester2List.get(0) == "d") {
                            semester2List.add(0, "b");
                            semester2List.addAll(1, value);
                            break;
                        }
                        int index = 0;
                        do {
                            index++;
                            if (index >= semester2List.size()) {
                                break;
                            }
                        } while (ScoreUtil.isNumber(semester2List.get(index)));
                        semester2List.addAll(index, value);
                        semester2List.add(index, "b");
                        break;
                    case "c":
                        if (!semester2List.contains("d")) {
                            semester2List.add(semester2List.size(),"c");
                            semester2List.addAll(semester2List.size(),value);
                            break;
                        }
                        int indexd = 0;
                        for (int i = 0; i < semester2List.size(); i++) {
                            if (semester2List.get(i) == "d") {
                                indexd = i;
                                break;
                            }
                        }
                        semester2List.addAll(indexd,value);
                        semester2List.add(indexd,"c");
                        break;
                    case "d":
                        semester2List.add(semester2List.size(),"d");
                        semester2List.addAll(semester2List.size(),value);
                        break;
                }
                list.addAll(beginIndex, semester2List);
                break;
        }
    }

    private static void showMenuOption() {
        System.out.println("┌- - - - - - - - - MỤC LỤC - - - - - - - - -┐");
        System.out.println("︲     1. Hiện danh sách lớp                ︲");
        System.out.println("︲     2. Sắp xếp theo tên                  ︲");
        System.out.println("︲     3. Sắp xếp theo ngày sinh            ︲");
        System.out.println("︲     4. Sắp xếp theo id                   ︲");
        System.out.println("︲     5. Hiện danh sách điểm trung bình    ︲");
        System.out.println("︲     6. Tra cứu kết quả học sinh          ︲");
        System.out.println("︲     7. Chỉnh sửa kết quả điểm            ︲");
        System.out.println("︲     8. Cập nhật điểm số học sinh         ︲");
        System.out.println("︲     9. Trở lại                           ︲");
        System.out.println("︲     0. Thoát                             ︲");
        System.out.println("└ - - - - - - - - - - - - - - - - - - - - - ┘");
    }

    private static void showMenuEditSemester() {
        System.out.println("┌- - - - - - - HỌC KỲ  - - - - - - -┐");
        System.out.println("︲     1. Học kì I                  ︲");
        System.out.println("︲     2. Học kì II                 ︲");
        System.out.println("︲     3. Trở lại                   ︲");
        System.out.println("︲     0. Thoát                     ︲");
        System.out.println("︲ (Ấn phím bất kì để trở lại MENU) ︲");
        System.out.println("└ - - - - - - - - - - - - - - - - - ┘");
    }

    private static void showMenuEditSubject() {
        System.out.println("┌- - - - - - - MỤC MÔN HỌC - - - - - - -┐");
        System.out.println("︲         1. Anh văn                   ︲");
        System.out.println("︲         2. Hóa học                   ︲");
        System.out.println("︲         3. Lịch sử                   ︲");
        System.out.println("︲         4. Ngữ văn                   ︲");
        System.out.println("︲         5. Sinh học                  ︲");
        System.out.println("︲         6. Tin học                   ︲");
        System.out.println("︲         7. Toán học                  ︲");
        System.out.println("︲         8. Vật lý                    ︲");
        System.out.println("︲         9. Trở lại                   ︲");
        System.out.println("︲         0. Thoát                     ︲");
        System.out.println("︲   (Ấn phím bất kì để trở lại MENU)   ︲");
        System.out.println("└ - - - - - - - - - - - - - - - - - - - ┘");
    }

    private static void showMenuEditScore() {
        System.out.println("┌- - - - - - - MỤC ĐIỂM - - - - - - -┐");
        System.out.println("︲      1. Điểm miệng                ︲");
        System.out.println("︲      2. Điểm 15 phút              ︲");
        System.out.println("︲      3. Điểm 1 tiết               ︲");
        System.out.println("︲      4. Điểm học kỳ               ︲");
        System.out.println("︲      5. Trở lại                   ︲");
        System.out.println("︲      0. Thoát                     ︲");
        System.out.println("︲ (Ấn phím bất kì để trở lại MENU)  ︲");
        System.out.println("└ - - - - - - - - -  - - - - - - - - ┘");
    }

    public static void showMenu(String grade) {
        System.out.println("        ✬ ✬ ✬ ✬ ✬ ✬ ✬KHỐI " + grade + "✬ ✬ ✬ ✬ ✬ ✬ ✬");
        System.out.println("        ✬                                   ✬");
        System.out.println("        ✬     1. Lớp " + grade + "A                    ✬");
        System.out.println("        ✬     2. Lớp " + grade + "B                    ✬");
        System.out.println("        ✬     3. Lớp " + grade + "C                    ✬");
        System.out.println("        ✬     4. Lớp " + grade + "D                    ✬");
        System.out.println("        ✬     5. Lớp " + grade + "E                    ✬");
        System.out.println("        ✬     6. Lớp " + grade + "G                    ✬");
        System.out.println("        ✬     7. Lớp " + grade + "H                    ✬");
        System.out.println("        ✬     8. Lớp " + grade + "K                    ✬");
        System.out.println("        ✬     9. Quay lại                   ✬");
        System.out.println("        ✬     0. Thoát                      ✬");
        System.out.println("        ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬");
    }
}
