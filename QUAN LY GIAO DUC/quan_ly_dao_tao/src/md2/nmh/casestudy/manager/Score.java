package md2.nmh.casestudy.manager;

import java.util.ArrayList;

public class Score {
    private ArrayList<Float> mouthScore = new ArrayList<>();
    private ArrayList<Float> fifteenScore = new ArrayList<>();
    private ArrayList<Float> oneLessonScore = new ArrayList<>();
    private float semesterScore;

    public Score() {
    }

    public ArrayList<Float> getMouthScore() {
        return mouthScore;
    }

    public void setMouthScore(ArrayList<Float> mouthScore) {
        this.mouthScore = mouthScore;
    }

    public ArrayList<Float> getFifteenScore() {
        return fifteenScore;
    }

    public void setFifteenScore(ArrayList<Float> fifteenScore) {
        this.fifteenScore = fifteenScore;
    }

    public ArrayList<Float> getOneLessonScore() {
        return oneLessonScore;
    }

    public void setOneLessonScore(ArrayList<Float> oneLessonScore) {
        this.oneLessonScore = oneLessonScore;
    }

    public float getSemesterScore() {
        return semesterScore;
    }

    public void setSemesterScore(float semesterScore) {
        this.semesterScore = semesterScore;
    }

    @Override
    public String toString() {
        return "Score{" +
                "mouthScore=" + mouthScore +
                ", fifteenScore=" + fifteenScore +
                ", oneLessonScore=" + oneLessonScore +
                ", semesterScore=" + semesterScore +
                '}';
    }
}
