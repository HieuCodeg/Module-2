package test;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//
//        System.out.println(list);
//        list.ensureCapacity(6);
//        ArrayList<Integer> list1 = (ArrayList<Integer>) list.clone();
//        System.out.println(list1);
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2 = list;
//        System.out.println(list2);
//        System.out.println(list.contains(5));
//        System.out.println(list.get(7));

        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        list.addFirst(1);
        list.addLast(9);
        list.remove( "3");
        System.out.println(list);

        LinkedList<Integer> list1 =  (LinkedList<Integer>) list.clone();
        System.out.println(list1);


    }
}
