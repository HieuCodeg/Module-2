package quanlysanpham;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    static int count = 0;
    private String name;
    private int price;
    private int quantity;
    private String describe;

    public Product() {
    }

    public Product(String id, String name, int price, int quantity, String describe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.describe = describe;
    }

    public void parse(String line) {
        String[] item = line.split(",");
        try {
            id = (item[0]);
            name = item[1];
            price = Integer.parseInt(item[2]);
            quantity = Integer.parseInt(item[3]);
            describe = item[4];
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Product.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
    public void display() {
        System.out.println("- Mã sản phẩm: " + id);
        System.out.println("- Tên: " + name);
        System.out.println("- Giá: " + price);
        System.out.println("- Số lượng: " + quantity);
        System.out.println("- Mô tả: " + describe);
    }

    @Override
    public String toString() {
        return id + "," + name + "," + price + ","+ quantity + "," + describe + '\n';
    }
}