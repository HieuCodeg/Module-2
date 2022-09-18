package quanlyphuongtien;

public class Car extends Vehicle{
    private int seatingCapacity;
    private String engineType;

    public Car(String id, String brand, int yearOfManafacture, int price, String color, int seatingCapacity, String engineType) {
        super(id, brand, yearOfManafacture, price, color);
        this.seatingCapacity = seatingCapacity;
        this.engineType = engineType;
        super.setType("0");
    }

    public Car() {
        super.setType("0");
    }

    public void moCuaSoTroi() {
        System.out.println("Đã mở cửa sổ trời, mời thưởng thức");
    }
    @Override
    public void dopNhienLieu() {
        System.out.printf("Đớp %s nhiên liệu cho 100km","7 lit xăng");
    }
    @Override
    public void showMe() {
        super.showMe();
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Car{" +
                "seatingCapacity=" + seatingCapacity +
                ", engineType='" + engineType + '\'' +
                '}';
    }
}
