package demerging_queue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Comparable<Student>{
    private String name;
    private boolean gender;
    private String birthday;

    public Student(String name, boolean gender, String birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    private class Birthday {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public Date getDate() {
        Date date;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(this.birthday);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.getDate().compareTo(o.getDate());
    }
}
