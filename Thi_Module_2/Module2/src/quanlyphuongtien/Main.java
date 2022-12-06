package quanlyphuongtien;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("X1","VN",2000,30000,"Đỏ",4,"V6");
        Vehicle motobike = new Mortorbike("X2","TQ",2020,2000,"Đen","110CC");
        Vehicle truck = new Truck("X3","LX",2010,30000,"Xanh","12 tấn");
        car.showMe();
        motobike.showMe();
        truck.showMe();
        List<Vehicle> list = new ArrayList<>();
        list.add(car);
        list.add(motobike);
        list.add(truck);
        for (Vehicle vehicle: list) {
            show(vehicle);
        }
    }

    public static void show(Vehicle vehicle) {
        if (vehicle instanceof Car) {
             ((Car) vehicle).moCuaSoTroi();
        }
        if (vehicle instanceof Truck) {
            ((Truck) vehicle).goHang();
        }
        if (vehicle instanceof Mortorbike) {
            ((Mortorbike) vehicle).bocDau();
        }
    }
}
