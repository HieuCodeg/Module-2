package he_nhi_phan;

import java.util.Scanner;
import java.util.Stack;

public class BinaryDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> surPlus = new Stack<Integer>();
        System.out.println("Nhập số dương: ");
        int number = sc.nextInt();

        while (number > 0) {
            int mod = number % 2;
            surPlus.push(mod);
            number /= 2;
        }

        System.out.println("Số nhị phân là: ");
        int n = surPlus.size();
        for (int i = 0; i < n; i++) {
            System.out.print(surPlus.pop());
        }
    }
}
