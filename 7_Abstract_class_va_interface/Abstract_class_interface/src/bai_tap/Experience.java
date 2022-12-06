package bai_tap;

import java.time.LocalDate;
import java.util.List;

public class Experience extends Employee{
    private int expnYear;
    private String proSkill;

    public Experience() {
        setEmployeeType();
    }

    public Experience(int expnYear, String proSkill) {
        setEmployeeType();
        this.expnYear = expnYear;
        this.proSkill = proSkill;
    }

    public Experience(int id, String fullName, LocalDate birthday, String phone, String email, List<Certificate> certificates, int expnYear, String proSkill) {
        super(id, fullName, birthday, phone, email, certificates);
        setEmployeeType();
        this.expnYear = expnYear;
        this.proSkill = proSkill;
    }

    @Override
    public void setEmployeeType() {
        this.employeeType = 0;
    }

    @Override
    public void showInfo() {
        System.out.println(this);
    }

    public int getExpnYear() {
        return expnYear;
    }

    public void setExpnYear(int expnYear) {
        this.expnYear = expnYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "expnYear=" + expnYear +
                ", proSkill='" + proSkill + '\'' +
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
