package sao_lop_triangle;

import java.util.Scanner;

public class Triangle extends Shape {
    private double size1 = 1.0;
    private double size2 = 1.0;
    private double size3 = 1.0;

    public Triangle() {
    }

    public Triangle(double size1, double size2, double size3) {
        this.size1 = size1;
        this.size2 = size2;
        this.size3 = size3;
    }

    public void setSize1(double size1) {
        this.size1 = size1;
    }

    public void setSize2(double size2) {
        this.size2 = size2;
    }

    public void setSize3(double size3) {
        this.size3 = size3;
    }

    public double getSize1() {
        return size1;
    }

    public double getSize2() {
        return size2;
    }

    public double getSize3() {
        return size3;
    }

    public double getPerimeter() {
        return getSize1() + getSize2() + getSize3();
    }

    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - getSize1()) * (p - getSize2()) * (p - getSize3()));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "size1=" + size1 +
                ", size2=" + size2 +
                ", size3=" + size3 +
                '}' + " Area = " + getArea() +
                "Perimeter = " + getPerimeter() + " by " +
                super.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap mau sac: ");
        String d = sc.nextLine();
        System.out.println("Nhap canh a = ");
        double a = sc.nextDouble();
        System.out.println("Nhap canh b = ");
        double b = sc.nextDouble();
        System.out.println("Nhap canh c = ");
        double c = sc.nextDouble();


        Triangle triangle = new Triangle(a,b,c);
        triangle.setColor(d);
        System.out.println(triangle.toString());

    }
}
