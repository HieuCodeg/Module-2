package test;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<String> list1 = new HashSet<>();

        list1.add("L");
        list1.add("R");
        list1.add("M");
//        list1.add("M");
//        list1.add("R");
//        list1.add("L");

        System.out.println(list1.size());
        System.out.println(list1);

        Set<String> list2 = new TreeSet<>();

        list2.add("L");
        list2.add("R");
        list2.add("M");
//        list2.add("M");
//        list2.add("R");
//        list2.add("L");

        System.out.println(list2.size());
        System.out.println(list2);
    }
}
