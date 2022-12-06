package dao_nguoc_mang;

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

        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1- j] = temp;
        }

        System.out.printf("%-21s", "\nPhần tử của mảng: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
