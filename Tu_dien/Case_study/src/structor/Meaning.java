package structor;

import java.util.ArrayList;
// Nghĩa của từ
public class Meaning {
    private String meaning;
    // Danh sách ví dụ
    private ArrayList<String> example = new ArrayList<>();

    public Meaning(String meaning) {
        this.meaning = meaning;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public ArrayList<String> getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example.add(example) ;
    }

    @Override
    public String toString() {
        String result = " - " + meaning+ "\n";
        for (int i = 0; i < example.size(); i++) {
            result += "= " + example.get(i) + "\n";
        }
        return result;
    }
}
