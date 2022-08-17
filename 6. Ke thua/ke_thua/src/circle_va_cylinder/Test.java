package circle_va_cylinder;

public class Test {
    public static void main(String[] args) {

        Circle circle = new Circle(2.0,"red");
        System.out.println(circle.toString());

        Cylinder cylinder = new Cylinder(3.0,"black",5.0);
        System.out.println(cylinder.toString());
    }
}
