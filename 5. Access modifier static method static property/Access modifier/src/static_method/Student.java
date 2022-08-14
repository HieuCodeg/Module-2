package static_method;

public class Student {

    private int rollno;
    private  String name;
    private static String college = "BBDIT";

    Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    static void change() {
        college = "CODEGYM";
    }

    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }
}
