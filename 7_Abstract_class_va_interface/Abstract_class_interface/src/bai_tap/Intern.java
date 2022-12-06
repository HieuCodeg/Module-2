package bai_tap;

import java.time.LocalDate;
import java.util.List;

public class Intern extends Employee{
    private String major;
    private String semester;
    private String universityName;

    public Intern() {
        setEmployeeType();
    }

    public Intern(String major, String semester, String universityName) {
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
        setEmployeeType();
    }

    public Intern(int id, String fullName, LocalDate birthday, String phone, String email, List<Certificate> certificates, String major, String semester, String universityName) {
        super(id, fullName, birthday, phone, email, certificates);
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
        setEmployeeType();
    }

    @Override
    public void setEmployeeType() {
        this.employeeType = 2;
    }

    @Override
    public void showInfo() {
        System.out.println(this);
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return "Intern{" +
                "major='" + major + '\'' +
                ", semester='" + semester + '\'' +
                ", universityName='" + universityName + '\'' +
                ", id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", certificates=" + certificates +
                ", employeeType=" + employeeType +
                '}';
    }
}
