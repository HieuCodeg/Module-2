package bai_tap;

public class Person {
    private int age;

    public Person(int age) {
        setAge(age);
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Age invalid");
            return;
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
