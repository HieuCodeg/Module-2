package bai_tap;

import java.time.LocalDate;
import java.util.List;

public abstract class Employee {
    static int employeeCount = 0;
    protected int id;
    protected String fullName;
    protected LocalDate birthday;
    protected String phone;
    protected String email;
    protected List<Certificate> certificates;
    protected int employeeType;

    public Employee(int id, String fullName, LocalDate birthday, String phone, String email, List<Certificate> certificates) {
        employeeCount++;
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.certificates = certificates;
    }

    public Employee() {
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    public int getEmployeeType() {
        return employeeType;
    }

    public abstract void setEmployeeType();

    public abstract void showInfo();
}
