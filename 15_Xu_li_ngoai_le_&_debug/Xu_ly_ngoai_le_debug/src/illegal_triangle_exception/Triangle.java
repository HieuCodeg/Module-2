package illegal_triangle_exception;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) throws Exception {


        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập cạnh a: ");
        double a = sc.nextDouble();
        System.out.println("Nhập cạnh b: ");
        double b = sc.nextDouble();
        System.out.println("Nhập cạnh c: ");
        double c = sc.nextDouble();

        if (a < 0 || b < 0 || c < 0 || a + b < c || a + c < b || c + b < a)
            throw new Exception("IllegalTriangleException");

    }
}
