package circle_va_cylinder;

public class Circle {
    private double radius;
    private String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }

    public double getPerimeter() {
        return  this.radius * 2 * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius= "
                + getRadius()
                + " and color= "
                + getColor();
    }
}
