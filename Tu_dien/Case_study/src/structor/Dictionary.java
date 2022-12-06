package structor;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Dictionary {
    private Map<String, Entities>  dictionary = new TreeMap<>();

    public void add(String word,Entities entry) {
        this.dictionary.put(word,entry);
    }

    public void remove(String word) {
       this.dictionary.remove(word);
    }

    public String find(String word) {
        return dictionary.get(word).toString();
    }

    public void drop(String word) {
        dictionary.remove(word);
    }

    public boolean isExist(String key) {
        if (dictionary.containsKey(key)) {
            return true;
        }
        return false;
    }

    public Entities getValue(String key) {
        return dictionary.get(key);
    }
    public void display() {
        Set<String> keySet = dictionary.keySet();
        for (Entities key : dictionary.values()) {
            System.out.println(key.toString() + "\n");
        }
    }

}
