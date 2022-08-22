package dao_nguoc_mang_so_nguyen;

import java.util.Scanner;
import java.util.Stack;

public class StackArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào size: ");
        int size = sc.nextInt();
        int[] list = new int[size];
        System.out.println("Nhập vào mảng số: ");
        for (int i = 0; i < size; i++) {
            list[i] = sc.nextInt();
        }
        Stack<Integer> stackInteger = new Stack<>();
        for (int i = 0; i < list.length; i++) {
            stackInteger.push(list[i]);
        }
        int count = 0;
        while (count < size) {
            list[count] = stackInteger.pop();
            count++;
        }
        System.out.println("Mảng đảo ngược: ");
        for (int item : list) {
            System.out.print(item + " ");
        }
    }

}
