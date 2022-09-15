package md2.nmh.casestudy;

import md2.nmh.casestudy.manager.Student;
import md2.nmh.casestudy.statistic.StudentsList;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        StudentsList studentsList = StudentsList.getInstance();
        List<Student> students = studentsList.findAll();
        for (Student student: students) {
            if (student.getScoreString().length() > 8) {
                System.out.println(student.getScoreString());
            }
        }
    }
}
