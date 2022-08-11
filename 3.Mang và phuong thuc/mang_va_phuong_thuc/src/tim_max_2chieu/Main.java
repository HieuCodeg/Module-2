package tim_max_2chieu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] arr =  array();
        int max = 0;
        System.out.println("Mảng của bạn:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(" " +arr[i][j]);
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
            System.out.println();
        }
        System.out.println("Giá trị lớn nhất: " + max);

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
