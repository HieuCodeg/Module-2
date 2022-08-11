package xoa_phan_tu;

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
                System.out.println("Size không vượt quá 20");
            if (size < 1)
                System.out.println("Size không tồn tại");
            System.out.print("Nhập lại: ");
            size = sc.nextInt();
        }

        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Nhập phần tử " + (i + 1) + ": ");
            array[i] = sc.nextInt();
            i++;
        }

        System.out.printf("%-20s", "Phần tử của mảng: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }

        System.out.println("\nNhập phần tử cần xóa: ");
        int x = sc.nextInt();

        boolean check = false;
        for (i = 0; i < array.length; i++) {
            if (array[i] == x) {
                check = true;
                break;
            }
        }
        if (check) {
            for (i = 0; i < array.length; i++) {
                if (array[i] == x) {
                    for (int j = i; j <array.length; j++) {
                        if (j == (array.length - 1)) {
                            array[j] = 0;
                        } else {
                            array[j] = array[j + 1];
                        }
                    }
                }
            }
            System.out.printf("%-20s", "Phần tử của mảng : ");
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j] + "\t");
            }
        } else {
            System.out.println("Mảng không thay đổi");
        }


    }
}
