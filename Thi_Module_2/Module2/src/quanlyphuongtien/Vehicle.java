package quanlyphuongtien;

public abstract class Vehicle {
    private String id;
    private String brand;
    private int yearOfManafacture;
    private int price;
    private String color;
    private String type;

    public Vehicle(String id, String brand, int yearOfManafacture, int price, String color) {
        this.id = id;
        this.brand = brand;
        this.yearOfManafacture = yearOfManafacture;
        this.price = price;
        this.color = color;
    }

    public Vehicle() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYearOfManafacture() {
        return yearOfManafacture;
    }

    public void setYearOfManafacture(int yearOfManafacture) {
        this.yearOfManafacture = yearOfManafacture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public abstract void dopNhienLieu();


    public void showMe() {
        System.out.print("Vehicle{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", yearOfManafacture=" + yearOfManafacture +
                ", price=" + price +
                ", color='" + color + '\'' +
                "  ");
    }
}
