package phuong_thuc_linkedlist;

public class MyLinkedListTest {
    public static void main(String[] args) {

        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        list.addFirst(1);
        list.addLast(9);

        list.printList();
        System.out.println();
        System.out.println(list.get(2));
        System.out.println();
        list.clear();
        list.printList();
//        System.out.println(list.indexOf(22));


//        list.add(4,10);
//        list.printList();
//        System.out.println();
//        list.remove(6);
//        System.out.println(list.size());
//        list.printList();
//        System.out.println();
//
//        MyLinkedList<Integer> list1 = (MyLinkedList<Integer>) list.clone();
//        list1.printList();
//        System.out.println();
//        list1.add(10);
//        list1.printList();
//        System.out.println();
//        list.printList();
//
//        System.out.println();
//        System.out.println(list1.contains(11));


    }
}
