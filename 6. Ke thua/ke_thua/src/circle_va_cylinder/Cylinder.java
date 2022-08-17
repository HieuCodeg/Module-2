package circle_va_cylinder;

public class Cylinder extends Circle{
    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }
    public double getVolume() {
        return getRadius() * getHeight();
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "A Cylinder height= "
                + getHeight()
                + " and volume= "
                + getVolume()
                + " by "
                +super.toString();
    }
}
