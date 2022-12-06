package quan_li_san_pham;

import java.io.Serializable;
import java.util.Scanner;

public class Product implements Serializable {
    private int id = 0;
    static int count = 0;
    private String name;
    private String manufacture;
    private int price;
    private String describe = "";

    public Product() {
        id = ++count;
    }

    public Product(int id, String name, String manufacture, int price, String describe) {
        id = ++count;
        this.name = name;
        this.manufacture = manufacture;
        this.price = price;
        this.describe = describe;
    }

    public void add() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập tên sản phẩm: ");
        name = sc.nextLine();

        System.out.println("Nhập hãng sản xuất: ");
        manufacture = sc.nextLine();

        System.out.println("Nhập giá: ");
        price = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập mô tả: ");
        describe = sc.nextLine();
    }

    public void parse(String line) {
        String[] item = line.split(",");
        try {
            id = Integer.parseInt(item[0]);
            name = item[1];
            manufacture = item[2];
            price = Integer.parseInt(item[3]);
            describe = item[4];
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void display() {
        System.out.println(this);
    }

    public String getFileLine() {
        return id + "," + name + "," + manufacture + "," +price +"," + describe + "\n";
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", price=" + price +
                ", describe='" + describe + '\'' +
                '}';
    }
}
