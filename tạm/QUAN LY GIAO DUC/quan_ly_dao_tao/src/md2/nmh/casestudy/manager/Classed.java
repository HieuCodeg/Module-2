package md2.nmh.casestudy.manager;

import md2.nmh.casestudy.services.ParseDate;

import java.util.ArrayList;
import java.util.List;

public class Classed {
    private String name;
    private int total = 0;
    private String headTeacher;
    private ArrayList<Student> studentslist = new ArrayList<>();

    public Classed(String name, String headTeacher) {
        this.name = name;
        this.headTeacher = headTeacher;
    }

    public Classed() {
    }

    public static Classed parseInfo(String line) {
        Classed classed = new Classed();
        String[] informationsList = line.split(",");
        classed.name = informationsList[0];
        classed.headTeacher = informationsList[1];
        return classed;
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

    public void setTotal() {
        this.total = ++this.total;
    }

    public String getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(String headTeacher) {
        this.headTeacher = headTeacher;
    }

    public List<Student> getStudentslist() {
        return studentslist;
    }

    public void setStudentslist(ArrayList<Student> studentslist) {
        this.studentslist = studentslist;
    }

    public void add(Student student) {
        this.studentslist.add(student);
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
