package gop_mang;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size1;
        int[] array1;
        System.out.print("Nhập size1: ");
        size1 = sc.nextInt();
        while ( size1 < 1) {
            System.out.println("Size không tồn tại");
            System.out.print("Nhập lại: ");
            size1 = sc.nextInt();
        }
        array1 = new int[size1];
        int i = 0;
        while (i < array1.length) {
            System.out.print("Nhập phần tử " + (i + 1) + ": ");
            array1[i] = sc.nextInt();
            i++;
        }

        int size2;
        int[] array2;
        System.out.print("Nhập size2: ");
        size2 = sc.nextInt();
        while ( size2 < 1) {
            System.out.println("Size không tồn tại");
            System.out.print("Nhập lại: ");
            size2 = sc.nextInt();
        }

        array2 = new int[size2];
        i = 0;
        while (i < array2.length) {
            System.out.print("Nhập phần tử " + (i + 1) + ": ");
            array2[i] = sc.nextInt();
            i++;
        }

        System.out.printf("%-21s", "Phần tử của mảng 1: ");
        for (int element : array1) {
            System.out.print(element + "\t");
        }
        System.out.printf("%-22s", "\nPhần tử của mảng 2: ");
        for (int item : array2) {
            System.out.print(item + "\t");
        }

        int[] array3 = new int[size1 + size2];
        for (i = 0; i< size1; i++) {
            array3[i] = array1[i];
        }
        int k = 0;
        for (i = size1; i< size1 + size2 ; i++) {
            array3[i] = array2[k];
            k++;
        }

        System.out.printf("%-22s", "\nPhần tử của mảng 3: ");
        for (int value : array3) {
            System.out.print(value + "\t");
        }
    }
}
