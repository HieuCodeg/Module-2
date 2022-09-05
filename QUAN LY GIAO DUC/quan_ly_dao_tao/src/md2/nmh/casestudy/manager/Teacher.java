package md2.nmh.casestudy.manager;

import java.time.LocalDate;

public class Teacher {
    private long id;
    private String name;
    private String gender;
    private LocalDate birthday;
    private String classed;
    private String subject;

    private String username;
    private String password;

    public Teacher(long id, String name, String gender, LocalDate birthday, String classed, String subject, String username, String password) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.classed = classed;
        this.subject = subject;
        this.username = username;
        this.password = password;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClassed() {
        return classed;
    }

    public void setClassed(String classed) {
        this.classed = classed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", classed='" + classed + '\'' +
                ", subject='" + subject + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
