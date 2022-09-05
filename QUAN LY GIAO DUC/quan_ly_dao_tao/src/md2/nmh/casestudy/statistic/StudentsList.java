package md2.nmh.casestudy.statistic;

import md2.nmh.casestudy.manager.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsList {
    private static StudentsList instance;
    public static StudentsList getInstance() {
        if (instance == null)
            instance = new StudentsList();
        return instance;
    }
    ArrayList<Student> students = new ArrayList<>();

    public StudentsList() {
    }

    public List<Student> findAll() {
        return students;
    }

    public void add(Student newStudent) {
        List<Student> students = findAll();
        students.add(newStudent);
    }
    public Student findById(long id) {
        for (Student student : findAll()) {
            if (student.getId() == id)
                return student;
        }
        return null;
    }

    public boolean existsById(long id) {
        return findById(id) != null;
    }

    public void remove(Student student) {
        students.remove(student);
    }

}
