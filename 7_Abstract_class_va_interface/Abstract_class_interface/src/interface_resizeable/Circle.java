package interface_resizeable;

public class Circle extends Shape implements Resizeable {
    private double radius;

    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }

    public double getPerimeter() {
        return this.radius * 2 * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius= "
                + getRadius()
                + " which is a subclass of "
                + super.toString();
    }

    public static void main(String[] args) {
//        Circle circle = new Circle();
//        System.out.println(circle);
//
//        circle = new Circle(3.5);
//        System.out.println(circle);
//
//        circle = new Circle("indigo", false, 3.5);
//        System.out.println(circle);
//
//        circle.resize(2);
//        System.out.println(circle);

        Circle[] c = new Circle[2];
        c[0] = new Circle(2.0);
        c[1] = new Circle(1.0);
        for (Circle item: c) {
            System.out.println(item);
            item.resize(10);
            System.out.println(item);
        }
    }

    @Override
    public void resize(double percent) {
        this.radius += this.radius * (percent / 100);
    }
}
