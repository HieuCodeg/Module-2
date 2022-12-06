package phuong_trinh_bac_hai;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập hệ số a: ");
        double a = sc.nextDouble();
        System.out.println("Nhập hệ số b: ");
        double b = sc.nextDouble();
        System.out.println("Nhập hệ số c: ");
        double c = sc.nextDouble();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        double delta = equation.getDiscriminant();
        if (delta > 0) {
            System.out.println("Nghiệm x1 = " + equation.getRoot1());
            System.out.println("Nghiệm x2 = " + equation.getRoot2());
        } else if (delta == 0) {
            System.out.println("Nghiệm x1 = x2 = " + equation.getRoot1());
        } else {
            System.out.println("Phương trình vô nghiệm");
        }
    }
}
