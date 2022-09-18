package quanlyphuongtien;

public class Truck extends Vehicle{
    private String tonnage;

    public Truck(String id, String brand, int yearOfManafacture, int price, String color, String tonnage) {
        super(id, brand, yearOfManafacture, price, color);
        this.tonnage = tonnage;
        super.setType("2");
    }

    public Truck() {
        super.setType("2");
    }

    public String getTonnage() {
        return tonnage;
    }

    public void setTonnage(String tonnage) {
        this.tonnage = tonnage;
    }

    public void goHang() {
        System.out.println("Đang gỡ hàng xuống");
    }
    @Override
    public void dopNhienLieu() {
        System.out.printf("Đớp %s nhiên liệu cho 100km","6 lít dầu");
    }
    @Override
    public void showMe() {
        super.showMe();
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Truck{" +
                "tonnage='" + tonnage + '\'' +
                '}';
    }
}
