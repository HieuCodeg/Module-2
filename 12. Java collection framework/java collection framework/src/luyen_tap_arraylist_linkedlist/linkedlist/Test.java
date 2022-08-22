package luyen_tap_arraylist_linkedlist.linkedlist;

public class Test {
    public static void main(String[] args) {

        ProductManager list = new ProductManager();

        list.add(01,"Ban",700000);
        list.add(02,"Ghe",900000);
        list.add(03,"Tu",300000);
        list.add(04,"Giuong",500000);
        list.render();

        list.change(1,"Ban xep",10000);
        list.render();

        list.remove(2);
        list.render();

        list.find("Tu");
        list.find("Laptop");

        list.ascendingSort();
        list.render();

        list.descendingSort();
        list.render();

    }
}
