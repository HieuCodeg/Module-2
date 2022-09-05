package md2.nmh.casestudy.manager;

import java.util.ArrayList;

public class Class {
    private String name;
    private int total;
    private Teacher headTeacher;
    private ArrayList<Student> studentslist = new ArrayList<>();

    public Class(String name, int total, Teacher headTeacher) {
        this.name = name;
        this.total = total;
        this.headTeacher = headTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Teacher getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(Teacher headTeacher) {
        this.headTeacher = headTeacher;
    }

    public ArrayList<Student> getStudentslist() {
        return studentslist;
    }

    public void setStudentslist(ArrayList<Student> studentslist) {
        this.studentslist = studentslist;
    }

    @Override
    public String toString() {
        return "Class{" +
                "name='" + name + '\'' +
                ", total=" + total +
                ", headTeacher=" + headTeacher +
                ", studentslist=" + studentslist +
                '}';
    }
}
