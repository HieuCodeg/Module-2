package bai_tap;

import java.time.LocalDate;
import java.util.List;

public class Fresher extends Employee{
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
        setEmployeeType();
    }

    public Fresher(String graduationDate, String graduationRank, String education) {
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
        setEmployeeType();
    }

    public Fresher(int id, String fullName, LocalDate birthday, String phone, String email, List<Certificate> certificates, String graduationDate, String graduationRank, String education) {
        super(id, fullName, birthday, phone, email, certificates);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
        setEmployeeType();
    }

    @Override
    public void setEmployeeType() {
        this.employeeType = 1;
    }

    @Override
    public void showInfo() {
        System.out.println(this);
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Fresher{" +
                "graduationDate=" + graduationDate +
                ", graduationRank='" + graduationRank + '\'' +
                ", education='" + education + '\'' +
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
