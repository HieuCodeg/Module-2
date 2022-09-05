package structor;

import java.util.ArrayList;
// Định nghĩa một từ (Loại từ)
public class Define {
    private String typeOfDefine;
    // Danh sách nghĩa của từ
    private ArrayList<Meaning> meaningList = new ArrayList<>();

    public Define(String typeOfDefine) {
        this.typeOfDefine = typeOfDefine;
    }

    public String getTypeOfDefine() {
        return typeOfDefine;
    }

    public void setTypeOfDefine(String typeOfDefine) {
        this.typeOfDefine = typeOfDefine;
    }

    public ArrayList<Meaning> getMeaning() {
        return meaningList;
    }

    public void setMeaning(Meaning meaning) {
        this.meaningList.add(meaning);
    }

    @Override
    public String toString() {
        String result = "* " + typeOfDefine + "\n";
        for (int i = 0; i < meaningList.size(); i++) {
            result += meaningList.get(i).toString();
        }
        return result;
    }
}
