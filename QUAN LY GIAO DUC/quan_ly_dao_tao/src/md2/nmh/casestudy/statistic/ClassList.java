package md2.nmh.casestudy.statistic;

import md2.nmh.casestudy.manager.Class;
import md2.nmh.casestudy.manager.Student;

import java.util.ArrayList;
import java.util.List;

public class ClassList {
    private static ClassList instance;
    public static ClassList getInstance() {
        if (instance == null)
            instance = new ClassList();
        return instance;
    }
    ArrayList<Class> classes = new ArrayList<>();

    public ClassList() {
    }

    public List<Class> findAll() {
        return classes;
    }

    public void add(Class newClass) {
        List<Class> classes = findAll();
        classes.add(newClass);
    }
    public void remove(Class oldClass) {
        classes.remove(oldClass);
    }
}
