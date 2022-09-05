package md2.nmh.casestudy.manager;

public class ScoreSubject {
    private String name;
    private Score semesterOne = new Score();
    private Score semesterTwo = new Score();
    private float averageScore = 0;

    public ScoreSubject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Score getSemesterOne() {
        return semesterOne;
    }

    public void setSemesterOne(Score semesterOne) {
        this.semesterOne = semesterOne;
    }

    public Score getSemesterTwo() {
        return semesterTwo;
    }

    public void setSemesterTwo(Score semesterTwo) {
        this.semesterTwo = semesterTwo;
    }

    public float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(float averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", semesterOne=" + semesterOne +
                ", semesterTwo=" + semesterTwo +
                ", averageScore=" + averageScore +
                '}';
    }
}
