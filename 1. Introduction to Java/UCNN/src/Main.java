import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a, b, c, max;

        System.out.println("Nhap so a");
        a = scanner.nextInt();

        System.out.println("Nhap so b");
        b = scanner.nextInt();

        System.out.println("Nhap so c");
        c = scanner.nextInt();

        max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        while (true) {
            if ((max % a == 0) && (max % b == 0) && (max % c == 0)) {
                break;
            }
            max ++;
        }
        System.out.println("BCNN cua " + a + ", " + b + ", " + c + " là: " + max);
    }
}