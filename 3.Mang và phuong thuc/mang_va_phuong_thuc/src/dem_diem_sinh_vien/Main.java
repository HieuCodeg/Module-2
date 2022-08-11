package dem_diem_sinh_vien;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập size: ");
        size = sc.nextInt();
        while (size > 20 || size < 1) {
            if (size > 20)
                System.out.println("Size không vượt quá 30");
            if (size < 1)
                System.out.println("Size không tồn tại");
            System.out.print("Nhập lại: ");
            size = sc.nextInt();
        }

        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Nhập điểm học sinh thứ " + (i + 1) + ": ");
            int diem = sc.nextInt();
            while (diem > 10 || diem < 0) {
                System.out.println("Điểm không hợp lệ!");
                System.out.print("Nhập điểm học sinh thứ " + (i + 1) + ": ");
                diem = sc.nextInt();
            }
            array[i] = diem;
            i++;
        }

        int count = 0;
        System.out.printf("%-20s", "Điểm của học sinh: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
            if (array[j] >= 5) {
                count++;
            }
        }

        System.out.printf("\nSố học sinh đỗ: " + count);

    }
}
