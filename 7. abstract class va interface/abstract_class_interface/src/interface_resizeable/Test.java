package interface_resizeable;

public class Test {
    public static void main(String[] args) {

        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(1.2);
        shapes[2] = new Square(3);
        shapes[1] = new Rectangle(2, 5);

        for (Shape item : shapes) {
            System.out.println(item);
            if (item instanceof Circle) {
                System.out.println(((Circle) item).getArea());
                ((Circle) item).resize(50);
                System.out.println(item);
                System.out.println(((Circle) item).getArea());
            }
            if (item instanceof Rectangle) {
                System.out.println(((Rectangle) item).getArea());
                ((Rectangle) item).resize(50);
                System.out.println(item);
                System.out.println(((Rectangle) item).getArea());
            }
        }


    }
}
