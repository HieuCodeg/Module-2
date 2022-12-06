package illegal_triangle_exception;

import java.util.Scanner;

public class illegal {

    public static void main(String[] args) throws IllegalTriangleException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập cạnh a: ");
        double a = sc.nextDouble();
        System.out.println("Nhập cạnh b: ");
        double b = sc.nextDouble();
        System.out.println("Nhập cạnh c: ");
        double c = sc.nextDouble();

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tam giác không hợp lệ");
        } else {
            System.out.println("Tam giac hop le!");
        }


    }


}
