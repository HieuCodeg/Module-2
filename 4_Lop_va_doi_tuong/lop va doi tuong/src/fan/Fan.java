package fan;

public class Fan {

    public final byte SLOW = 1;
    public final byte MEDIUM = 2;
    public final byte FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan() {
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        if (this.on)
            return "fan is on: speed = " + this.speed + "; color = " + this.color + "; radius = " + this.radius;
        else
            return "fan is off: color = " + this.color + "; radius = " + this.radius;
    }
}
