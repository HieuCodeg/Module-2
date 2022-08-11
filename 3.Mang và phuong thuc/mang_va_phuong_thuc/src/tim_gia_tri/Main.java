package tim_gia_tri;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên sinh viên: ");
        String name = sc.nextLine();

        boolean isExist = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(name)) {
                System.out.println("Vị trí trong danh sách của học sinh " + name + "là: " + i);
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Không tìm thấy học sinh " + name + " trong danh sách");
        }
    }
}
