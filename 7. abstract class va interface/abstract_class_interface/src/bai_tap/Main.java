package bai_tap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Certificate> array = new ArrayList<Certificate>();
        array.add(new Certificate(1, "Toan", "A", "1/1/2022"));
        array.add(new Certificate(2, "Van", "A", "1/2/2022"));

        Employee nv1 = new Experience(1, "Nguyễn A",  LocalDate.of(2017, 1, 13), "0324321222", "A@gmail.com", array, 1, "good");
        System.out.println(nv1.toString());
        System.out.println(Employee.getEmployeeCount());

        Employee nv2 = new Fresher(2,"Nguyễn B", LocalDate.parse("2000-12-02"), "0384321222", "B@gmail.com", array,"2/2/2017","A","Đại học Thăng Long");
        System.out.println(nv2.toString());
        System.out.println(Employee.getEmployeeCount());

        Employee nv3 = new Intern(3,"Nguyễn C", LocalDate.of(2017, 1, 13), "0322321222", "c@gmail.com", array,"Bộ binh","I","Trường A");
        System.out.println(nv3.toString());
        System.out.println(Employee.getEmployeeCount());


    }
}
