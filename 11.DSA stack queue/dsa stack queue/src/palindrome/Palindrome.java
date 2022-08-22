package palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi kiểm tra: ");
        String st = sc.nextLine();
        String s = st.toUpperCase();
        Stack<Character> palindromeStack = new Stack<Character>();
        Queue<Character> palindromeQueue = new LinkedList<Character>();

        for (int i = 0; i < s.length(); i++) {
            char charOfString = s.charAt(i);
            palindromeStack.push(charOfString);
            palindromeQueue.add(charOfString);
        }
        boolean isPalindrome = true;
        for (int i = 0; i < s.length(); i++) {
            if (palindromeStack.pop() != palindromeQueue.remove()) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println(st + " là chuỗi palindrome");
        } else {
            System.out.println(st + " không phải là chuỗi palindrome");
        }
    }
}
