package demerging_queue;

import java.util.*;

public class Demerging {
    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("Nguyen Van A",true, "10/1/2011"));
        list.add(new Student("Nguyen Van B",true, "1/2/2011"));
        list.add(new Student("Nguyen Van C",true, "01/3/2011"));
        list.add(new Student("Nguyen Thi F",false, "1/1/2010"));
        list.add(new Student("Nguyen Thi E",false, "1/2/2010"));
        list.add(new Student("Nguyen Thi A",false, "1/2/2010"));

        Collections.sort(list);
        list.forEach(student -> System.out.println(student.toString()));
        Queue<Student> maleQueue = new PriorityQueue<Student>();
        Queue<Student> femaleQueue = new PriorityQueue<Student>();

        for (int i = 0; i < list.size(); i++) {
            Student item = list.get(i);
            if (item.isGender()) {
                maleQueue.add(item);
            } else {
                femaleQueue.add(item);
            }
        }

        ArrayList<Student> newList = new ArrayList<Student>();
        while (!maleQueue.isEmpty()) {
            newList.add(maleQueue.remove());
        }
        while (!femaleQueue.isEmpty()) {
            newList.add(femaleQueue.remove());
        }
        System.out.println("---------------");
        newList.forEach(student -> System.out.println(student.toString()));


    }
}
