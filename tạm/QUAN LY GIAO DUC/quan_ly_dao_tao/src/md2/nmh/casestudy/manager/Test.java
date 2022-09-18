package md2.nmh.casestudy.manager;

import md2.nmh.casestudy.statistic.StudentsList;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Student> studentsList = StudentsList.getInstance().findAll();
        for (Student student:studentsList) {
            if (student.getId() == 1000006) {
                System.out.println(student.toString());
            }
        }

    }
}
