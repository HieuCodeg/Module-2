package md2.nmh.casestudy.services;

import md2.nmh.casestudy.manager.Teacher;
import md2.nmh.casestudy.statistic.TeacherList;

import java.util.List;
import java.util.Scanner;

public class AppUtils {
    public static Scanner sc = new Scanner(System.in);
    public static String retryString(String string) {
        String result;
        System.out.printf("%50s %s"," "," ⭆ ");
        while ((result = sc.nextLine()).isEmpty()) {
            System.out.printf("%50s không được để trống\n", string);
            System.out.printf("%50s %s"," "," ⭆ ");
        }
        return result;
    }
    public static int retryChoose(int min, int max) {
        int option;
        do {
            System.out.print(" ⭆ ");
            try {
                option = Integer.parseInt(sc.nextLine());
                if (option > max || option < min) {
                    System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                    continue;
                }
                break;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (true);
        return option;
    }
    public static boolean retryUserName(String userName) {
        List<Teacher> teachers = TeacherList.getInstance().findAll();
        for (Teacher teacher:teachers) {
            if (teacher.getUsername().equals(userName)) {
                return true;
            }
        }
        return false;
    }
    public static Teacher retryPassword(String userName, String password) {
        List<Teacher> teachers = TeacherList.getInstance().findAll();
        for (Teacher teacher:teachers) {
            if (teacher.getUsername().equals(userName) && teacher.getPassword().equals(password)) {
                return teacher;
            }
        }
        return null;
    }
    public static void step() {
        System.out.printf("%50s %s"," "," Nhấn phím bất kì để tiếp tục !!!");
        String s = sc.nextLine();
    }

}
