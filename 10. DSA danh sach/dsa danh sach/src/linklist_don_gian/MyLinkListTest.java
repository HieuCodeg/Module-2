package linklist_don_gian;

public class MyLinkListTest {
    public static void main(String[] args) {
        System.out.println("Testing");
        MyLinkList list = new MyLinkList(10);
        list.addFirst(11);
        list.addFirst(12);
        list.addFirst(13);

        list.add(4,9);
        list.add(8,4);
        list.printList();
    }
}
