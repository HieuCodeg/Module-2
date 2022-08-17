package interface_resizeable;

public class Test {
    public static void main(String[] args) {

        Circle[] circle = new Circle[2];
        circle[0] = new Circle(2.0);
        circle[1] = new Circle(3.5);

        for (Circle item: circle) {
            System.out.println(item);
            System.out.println(item.getArea());
            item.resize(50);
            System.out.println(item);
            System.out.println(item.getArea());
        }


    }
}
