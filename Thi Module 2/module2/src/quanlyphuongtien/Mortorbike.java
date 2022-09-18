package quanlyphuongtien;

public class Mortorbike extends Vehicle{
    private String cubicCentimeter;

    public String getCubicCentimeter() {
        return cubicCentimeter;
    }

    public Mortorbike(String id, String brand, int yearOfManafacture, int price, String color, String cubicCentimeter) {
        super(id, brand, yearOfManafacture, price, color);
        this.cubicCentimeter = cubicCentimeter;
        super.setType("0");
    }

    public Mortorbike() {
        super.setType("0");
    }

    public void setCubicCentimeter(String cubicCentimeter) {
        this.cubicCentimeter = cubicCentimeter;
    }

    public void bocDau() {
        System.out.println("Bốc đầu vui ghê");
    }
    @Override
    public void dopNhienLieu() {
        System.out.printf("Đớp %s nhiên liệu cho 100km","1.5 lit xăng");
    }
    @Override
    public void showMe() {
        super.showMe();
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Mortorbike{" +
                "cubicCentimeter='" + cubicCentimeter + '\'' +
                '}';
    }
}
