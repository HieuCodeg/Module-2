package md2.nmh.casestudy.manager;

import java.util.Map;
import java.util.TreeMap;

public class ScoreStudent {
    private Map<String, ScoreSubject> myScore = new TreeMap<>();

    public ScoreStudent() {
        initialize();
    }

    public void initialize() {
        myScore.put("Toán",new ScoreSubject("Toán"));
        myScore.put("Lý",new ScoreSubject("Lý"));
        myScore.put("Hóa",new ScoreSubject("Hóa"));
        myScore.put("Sinh",new ScoreSubject("Sinh"));
        myScore.put("Tin",new ScoreSubject("Tin"));
        myScore.put("Văn",new ScoreSubject("Văn"));
        myScore.put("Anh",new ScoreSubject("Anh"));
        myScore.put("Sử",new ScoreSubject("Sử"));
    }

}
