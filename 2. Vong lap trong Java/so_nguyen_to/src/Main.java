import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số kiểm tra: ");
        int a = sc.nextInt();
        int count = 0;

        if (a <= 1) {
            System.out.println(a + " không phải là số nguyên tố");
        } else {
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) {
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(a + " là số nguyên tố");
            } else {
                System.out.println(a + " không phải là số nguyên tố");
            }
        }
    }
}
