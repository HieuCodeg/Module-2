package dao_nguoc_mang_so_nguyen;

import java.util.Scanner;
import java.util.Stack;

public class StackString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String s = sc.nextLine();

        Stack<String> stackStrings = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stackStrings.push(s.charAt(i) + "");
        }

        System.out.println("Chuỗi đảo ngược: ");
        for (int i = 0; i < s.length(); i++) {
            System.out.print(stackStrings.pop());
        }
    }
}
