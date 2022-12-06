package luyen_tap_arraylist_linkedlist.linkedlist;

import java.util.*;

public class ProductManager {

    private LinkedList<Product> products = new LinkedList<Product>();

    public ProductManager() {
    }

    public void add(int ID, String name, int price) {
        products.add(new Product(ID, name, price));
    }

    public void change(int ID, String name, int price) {
        for (int i = 0; i < products.size(); i++) {
            Product item = products.get(i);
            if (item.getID() == ID) {
                products.set(i, new Product(ID, name, price));
            }
        }
    }

    public void remove(int ID) {
        for (int i = 0; i < products.size(); i++) {
            Product item = products.get(i);
            if (item.getID() == ID) {
                products.remove(i);
            }
        }
    }

    public void render() {
        System.out.println("_______________");
        for (Product item : products) {
            System.out.println(item.toString());
        }
    }

    public void find(String name) {
        for (Product item : products) {
            if (item.getName() == name) {
                System.out.println(item.toString());
                return;
            }
        }
        System.out.println(name + " invalid");
    }

    public void ascendingSort() {
        Collections.sort(products);
    }

    public void descendingSort() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() < o2.getPrice()) {
                    return 1;
                } else if (o1.getPrice() > o2.getPrice()) {
                    return -1;
                } else
                return 0;
            }
        });
    }
}
