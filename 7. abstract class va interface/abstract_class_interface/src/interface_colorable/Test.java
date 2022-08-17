package interface_colorable;

import interface_resizeable.Square;

public class Test {
    public static void main(String[] args) {
        Square[] squares = new Square[2];
        squares[0] = new Square(2);
        squares[1] = new Square(3);

        for (Square item: squares) {
            System.out.println(item);
            System.out.println(item.getArea());
            item.howToColor();
        }
    }
}
