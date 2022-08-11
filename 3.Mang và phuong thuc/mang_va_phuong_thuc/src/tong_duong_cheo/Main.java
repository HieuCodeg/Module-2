package tong_duong_cheo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[][] arr =  array();
        int count = 0;
        int result = 0;
        do {
            result += arr[count][count];
            count++;
        } while (count < arr.length);
        System.out.println("Tổng chéo: " + result);


    }
    public static int[][] array() {
        int size;
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

        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println("Nhập giá trị phần tử ["+ i + ", "+ j + "]: ");
                arr[i][j] = sc.nextInt();
            }
        }

        for (int[] items:arr) {
            for (int item: items) {
                System.out.print(item+ " ");
            }
            System.out.println();
        }
        return  arr;
    }
}
