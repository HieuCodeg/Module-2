package static_method;

public class TestStaticMethod {

    public static void main(String[] args) {
        Student.change();

        Student s1 = new Student(111, "Nguyen");
        Student s2 = new Student(222, "Minh");
        Student s3 = new Student(333, "Hieu");

        s1.display();
        s2.display();
        s3.display();
    }
}
