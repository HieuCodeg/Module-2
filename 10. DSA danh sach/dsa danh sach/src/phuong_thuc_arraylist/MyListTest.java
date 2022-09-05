package phuong_thuc_arraylist;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.add(2);
        list.add(0,3);
        list.add(0,4);
        list.add(5);
        list.remove(10);
        list.print();
        System.out.println(list.size());
        MyList<Integer> list1 = (MyList<Integer>) list.clone();
        list1.print();
        System.out.println(list1.size());
        System.out.println(list.contains(10));
        System.out.println(list.indexOf(6));
        System.out.println(list.get(5));
        list1.clear();
        System.out.println(list1.size());
        MyList<String> lsis = new MyList<>();
    }
}
