package lop_stopwatch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StopWatch time = new StopWatch();

        long[] arr = new long[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.round(Math.random() * 1000);
        }

//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();

        time.start();
        System.out.println("Thời gian bắt đầu: " + time.getStartTime());
        for (int i = 0; i < arr.length - 1; i++) {
            // Tìm phần tử nhỏ nhất trong mảng chưa được sắp xếp
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Hoán đổi phần tử nhỏ nhất và phần tử đầu tiên
            long temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        time.stop();
        System.out.println("Thời gian kết thúc: " + time.getEndTime());

        System.out.println("Thời gian thực hiện: " + time.getElapsedTime());

//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
    }
}
