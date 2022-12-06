package interface_resizeable;

import interface_colorable.Colorable;

public class Square extends Rectangle implements Resizeable, Colorable {
    public Square() {
    }

    public Square(double size) {
        super(size,size);
    }

    public Square(double size, String color, boolean filled) {
        super(color, filled,size, size);
    }

    public double getSize() {
        return getWidth();
    }

    public void setSize(double size) {
       super.setWidth(size);
        super.setLength(size);
    }

    @Override
    public void setWidth(double width) {
        setWidth(width);
    }

    @Override
    public void setLength(double length) {
        setLength(length);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSize()
                + ", which is a subclass of "
                + super.toString();
    }
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        square = new Square(2.3);
        System.out.println(square);

        square.setSize(2.2);
        System.out.println(square);
        square.resize(50);
        System.out.println(square);
    }
    @Override
    public void resize(double percent) {
        this.setSize(getSize() + (getSize() * (percent/100)));
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}
