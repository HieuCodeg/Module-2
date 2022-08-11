package tong_cot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] arr =  array();

        System.out.println("Mảng của bạn:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(" " +arr[i][j]);
            }
            System.out.println();
        }

        System.out.println("Nhập cột bạn muốn tính tổng: ");
        int column = sc.nextInt();
        while (arr[0].length < column || column <= 0) {
            System.out.println("Cột không hợp lệ, vui lòng nhập lại: ");
            column = sc.nextInt();
        }

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == column - 1) {
                    result += arr[i][j];
                }
            }
        }
        System.out.println("Tổng các số ở cột " + column + " là: " + result);

    }
    public static int[][] array() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập kích thước hàng: ");
        int row = sc.nextInt();
        System.out.println("Nhập kích thước cột: ");
        int column = sc.nextInt();
        int[][] arr = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.println("Nhập giá mảng ["+ i + ", "+ j + "]: ");
                arr[i][j] = sc.nextInt();
            }
        }
        return  arr;
    }
}
