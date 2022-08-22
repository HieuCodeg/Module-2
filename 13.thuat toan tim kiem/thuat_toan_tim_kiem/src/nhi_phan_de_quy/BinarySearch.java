package nhi_phan_de_quy;

import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào kích cỡ: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Nhap vao mang arr: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Mang cua ban: ");
        for (int item : arr) {
            System.out.print(item + " ");
        }

        System.out.print("\nMang sau khi sap xep: ");
        sort(arr);
        for (int item : arr) {
            System.out.print(item + " ");
        }

        System.out.print("\nNhap phan tu can tim: ");
        int value = sc.nextInt();
        int result = binarySearch(arr, 0, arr.length - 1, value);
        if (result != -1) {
            System.out.println("\nTim thay " + value + " tai vi tri: " + result);
        } else {
            System.out.println("\nKhong tim thay " + value);
        }
    }

    public static void sort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[minIndex] > list[j])
                    minIndex = j;
            }
            if (minIndex != i) {
                int temp = list[minIndex];
                list[minIndex] = list[i];
                list[i] = temp;
            }
        }
    }

    public static int binarySearch(int[] list, int low, int high, int key) {
        if (high >= low) {
            int mid = (low + high) / 2;
            if (key == list[mid])
                return mid;
            if (key > list[mid])
                return binarySearch(list, mid + 1, high, key);
            return binarySearch(list, low, mid - 1, key);
        }
        return -1;

    }
}
