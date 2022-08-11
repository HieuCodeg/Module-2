package dem_ky_tu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String arr = "Hom nay troi dep qua ha ha ha";
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào ký tự: ");
        String input = sc.nextLine();
        while (input.length() != 1) {
            System.out.println("Vui lòng nhập lại:");
            input = sc.nextLine();
        }
        char character = input.charAt(0);
        int count = 0;
        for (int i = 0; i < arr.length(); i++) {
            if (character == arr.charAt(i)) {
                count++;
            }
        }
        System.out.println("Chuỗi: " + arr);
        System.out.println("Số lần xuất hiện ký tự " + character + " là: " + count);
    }
}
