package structor;

import java.util.ArrayList;
// Mục từ
public class Entities {
    private String name;
    private String pronounce;
    private ArrayList<Define> definesList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPronounce() {
        return pronounce;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }
    public Define getDefine(String defineType) {
        Define temp = new Define(defineType);
        for (int i = 0; i < definesList.size(); i++) {
            String holder = definesList.get(i).getTypeOfDefine();
            if (holder.equals(defineType)) {
                temp = definesList.get(i);
                return temp;
            }
        }
        definesList.add(temp);
        return temp;
    }

    public ArrayList<Define> getDefinesList() {
        return definesList;
    }

    public void setDefinesList(Define define) {
        this.definesList.add(define);
    }

    public Entities(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String result = "@ " + name + pronounce + "\n";
        for (int i = 0; i < definesList.size(); i++) {
            result += definesList.get(i).toString();
        }
        return result;
    }
}
