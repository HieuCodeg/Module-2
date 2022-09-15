package md2.nmh.casestudy.services;

import md2.nmh.casestudy.manager.Gender;
import md2.nmh.casestudy.manager.InputOption;
import md2.nmh.casestudy.manager.Role;
import md2.nmh.casestudy.manager.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InformationInput {
    public static Scanner sc = new Scanner(System.in);

    public static String inputName(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập họ và tên (vd: Nguyễn Minh Hiếu) ");
                System.out.println("(Chữ cái đầu viết hoa, tên không bao gồm ký tự đặc biệt)");
                break;
            case UPDATE:
                System.out.println("Nhập tên mà bạn muốn sửa đổi");
                System.out.println("(Chữ cái đầu viết hoa, tên không bao gồm ký tự đặc biệt)");
                break;
        }
        String fullName;
        while (!Validex.isNameValid(fullName = AppUtils.retryString("Họ và tên"))) {
            System.out.println("Tên " + fullName + " không đúng định dạng." + " Vui lòng nhập lại!");
            System.out.println("(Chữ cái đầu viết hoa, tên không bao gồm ký tự đặc biệt)");
        }
        return fullName;
    }

    public static Gender inputGender() {
        int choosen = -1;
        do {
            System.out.println("Lựa chọn giới tính");
            System.out.println("1. Nam");
            System.out.println("2. Nữ");
            try {
                choosen = Integer.parseInt(sc.nextLine());
                switch (choosen) {
                    case 1:
                        return Gender.Nam;
                    case 2:
                        return Gender.Nữ;
                    default:
                        System.out.println("Chưa chính xác, vui lòng chọn lại!");
                        break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage() + " Vui lòng nhập lại!");
            }
        } while (true);
    }

    public static Role inputRole() {
        int choosen = -1;
        do {
            System.out.println(" ░░░░░  Lựa chọn quyền truy cập  ░░░░░");
            System.out.println(" ░░     1. ADMIN                    ░░");
            System.out.println(" ░░     2. USER                     ░░");
            System.out.println(" ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            try {
                choosen = Integer.parseInt(sc.nextLine());
                switch (choosen) {
                    case 1:
                        return Role.ADMIN;
                    case 2:
                        return Role.USER;
                    default:
                        System.out.println("Chưa chính xác, vui lòng chọn lại!");
                        break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage() + " Vui lòng nhập lại!");
            }
        } while (true);
    }

    public static String inputBirthday(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập ngày sinh: (vd: 02/02/2022)");
                break;
            case UPDATE:
                System.out.println("Nhập ngày sinh mà bạn muốn sửa đổi: ");
                break;
        }
        String birthday;
        while (!Validex.isBirthdayValid(birthday = AppUtils.retryString("Ngày sinh"))) {
            System.out.println("Giá trị " + birthday + " không đúng định dạng." + " Vui lòng nhập lại!");
            System.out.println("Nhập ngày sinh: (vd: 02/02/2022) ");
        }
        return birthday;
    }

    public static String inputPhoneNumber(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập số điện thoại: (vd: 0989989999)");
                System.out.println("(Số điện thoại có 10 số, bắt đầu bằng số 0, không được bắt đầu bằng 00");
                break;
            case UPDATE:
                System.out.println("Nhập số điện thoại cần sửa: ");
                System.out.println("(Số điện thoại có 10 số, bắt đầu bằng số 0, không được bắt đầu bằng 00");
                break;
        }
        String phoneNumber;
        while (!Validex.isPhoneValid(phoneNumber = AppUtils.retryString("Số điện thoại"))) {
            System.out.println("Số " + phoneNumber + " không đúng định dạng." + " Vui lòng nhập lại!");
            System.out.println("(Số điện thoại có 10 số, bắt đầu bằng số 0, không được bắt đầu bằng 00");
        }
        return phoneNumber;
    }

    public static String inputEmail(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập Email: (vd: Emailvidu@gmail.com)");
                System.out.println("(Email bao gồm chữ a-Z và số 0 - 9 và ký tự '.', chú ý trước @ không được '.' !");
                break;
            case UPDATE:
                System.out.println("Nhập Email cần sửa: ");
                System.out.println("(Email bao gồm chữ a-Z và số 0 - 9 và ký tự '.', chú ý trước @ không được '.' !");
                break;
        }
        String email;
        while (!Validex.isEmailValid(email = AppUtils.retryString("Email"))) {
            System.out.println(email + " không đúng định dạng." + " Vui lòng nhập lại!");
            System.out.println("(Email bao gôm chữ a-Z và số 0 - 9 và ký tự '.', chú ý trước @ không được '.' !");
        }
        return email;
    }

    public static String inputClass(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập Lớp: (vd: 10A)");
                System.out.println("(Đây là trường cấp 3, chỉ mở được A-K lớp !");
                break;
            case UPDATE:
                System.out.println("Nhập Lớp cần sửa: ");
                System.out.println("(Đây là trường cấp 3, chỉ mở được A-K lớp !");
                break;
        }
        String classed;
        while (!Validex.isClassValid(classed = AppUtils.retryString("Email"))) {
            System.out.println(classed + " không đúng định dạng." + " Vui lòng nhập lại!");
            System.out.println("(Đây là trường cấp 3, chỉ mở được A-K lớp !");
        }
        return classed;
    }

    public static String inputPassword() {
        System.out.println("Nhập Password: ");
        System.out.println("    + Không bao gồm dấu cách, ký tự ngắt dòng, ít nhất 6 ký tự");
        System.out.println("    + Phải chứa ít nhất 1 ký tự số [0-9]");
        System.out.println("    + Phải chứa ít nhất 1 ký tự chữ hoa");
        System.out.println("    + Phải chứa ít nhất 1 ký tự chữ thường");
        System.out.println("    + Phải chứa ít nhất 1 ký tự đặc biệt [! @ # $ % ^ & + = _ ]]");

        String password;
        while (!Validex.isPasswordValid(password = AppUtils.retryString("Password"))) {
            System.out.println(password + " không đúng định dạng hoặc chưa đủ mạnh." + " Vui lòng nhập lại!");
        }
        return password;
    }

    public static String inputUsername() {
        System.out.println("Nhập Username (>6 kí tự, không bao gồm dấu cách, không dấu)");
        String username;
        do {
            username = AppUtils.retryString("Username");
            if (!Validex.isUsernameValid(username) ) {
                System.out.println(username + " không đúng định dạng." + " Vui lòng nhập lại!");
                System.out.println("(>6 kí tự, không bao gồm dấu cách, không dấu)");
            }
            if (AppUtils.retryUserName(username)) {
                System.out.println("Tên đăng nhập đã tồn tại !!!");
            }
        } while (!Validex.isUsernameValid(username) || AppUtils.retryUserName(username));
        return username;
    }

    public static ArrayList<Float> inputListNumberScore() {
        ArrayList<Float> list = new ArrayList<>();
        float mark;
        while (true) {
            System.out.println("Nhập điểm: ");
            try {
                mark = (float) (Math.round(Float.parseFloat(sc.nextLine()) * 10)) / 10;
                list.add(mark);
                System.out.println("Nhấn 'q' để hoàn thành / phím bất kì để tiếp tục");
                String option = sc.nextLine();
                if (option.equals("q")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Điểm không hợp lệ! Vui lòng nhập lại!");
            }
        }

        return list;
    }
    public static List<Float> inputListNumberScore(List<Float> list) {
        float mark;
        while (true) {
            System.out.println("Nhập điểm: ");
            try {
                mark = (float) (Math.round(Float.parseFloat(sc.nextLine()) * 10)) / 10;
                list.add(mark);
                System.out.println("Nhấn 'q' để hoàn thành / phím bất kì để tiếp tục");
                String option = sc.nextLine();
                if (option.equals("q")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Điểm không hợp lệ! Vui lòng nhập lại!");
            }
        }
        return list;
    }
    public static ArrayList<String> inputListStringScore() {
        ArrayList<String> list = new ArrayList<>();
        float mark;
        while (true) {
            System.out.println("Nhập điểm: ");
            try {
                mark = (float) (Math.round(Float.parseFloat(sc.nextLine()) * 10)) / 10;
                list.add(String.valueOf(mark));
                System.out.println("Nhấn 'q' để hoàn thành / phím bất kì để tiếp tục");
                String option = sc.nextLine();
                if (option.equals("q")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Điểm không hợp lệ! Vui lòng nhập lại!");
            }
        }
        return list;
    }
    public static float inputScore() {
        float mark;
        while (true) {
            System.out.println("Nhập điểm: ");
            try {
                mark = (float) (Math.round(Float.parseFloat(sc.nextLine()) * 10)) / 10;
                return mark;
            } catch (Exception e) {
                System.out.println("Điểm không hợp lệ! Vui lòng nhập lại!");
            }
        }
    }
    public static Subject inputSubject() {
        System.out.println("☑ Vui lòng lựa chọn môn học giảng dạy: ");
        System.out.println("    ┌ - - - - - - MÔN HỌC - - - - - - ┐");
        System.out.println("    ︲     0. Toán học                ︲");
        System.out.println("    ︲     1. Vật lý                  ︲");
        System.out.println("    ︲     2. Hóa học                 ︲");
        System.out.println("    ︲     3. Sinh học                ︲");
        System.out.println("    ︲     4. Tin học                 ︲");
        System.out.println("    ︲     5. Ngữ văn                 ︲");
        System.out.println("    ︲     6. Lịch sử                 ︲");
        System.out.println("    ︲     7. Anh văn                 ︲");
        System.out.println("    ︲     8. Địa lý                  ︲");
        System.out.println("    └ - - - - - - - - - - - - - - - - ┘");
        int option = AppUtils.retryChoose(0, 8);
        return Subject.parseSubject(option);
    }
}
