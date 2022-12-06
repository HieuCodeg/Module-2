package stack_kiem_tra_dau_ngoac;

import java.util.Scanner;
import java.util.Stack;

public class BracketStack {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi kiểm tra: ");
        String st = sc.nextLine();

        Stack<Character> bracketStack = new Stack<Character>();
        boolean isValid = true;
        for (int i = 0; i < st.length(); i++) {
           char charOfString = st.charAt(i);
            if (charOfString == '(') {
                bracketStack.push(charOfString);
            }
            if (charOfString == ')') {
                if (bracketStack.size() == 0) {
                    isValid = false;
                    break;
                }
                bracketStack.pop();
            }
        }

        if (isValid && bracketStack.isEmpty()) {
            System.out.println("Biểu thức hợp lệ");
        } else {
            System.out.println("Biểu thức không hợp lệ");
        }
    }
}
