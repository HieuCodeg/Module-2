package minh_hoa_sap_xep_noi_bot;

import java.util.Scanner;

public class BubbleSortByStep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter list size: ");
        int size = sc.nextInt();
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter value " + i +": ");
            list[i] = sc.nextInt();
        }
        System.out.println("Your input list: ");
        for (int item: list) {
            System.out.print(item + " ");
        }
        System.out.println();
        bubbleSortByStep(list);
    }

    public static void bubbleSortByStep(int[] list) {
        boolean needNextPass = true;
        for (int i = 1; i < list.length && needNextPass; i++) {
            needNextPass = false;
            for (int j = 0; j < list.length - i ; j++) {
                if (list[j] > list[j+1]) {
                    System.out.println("Swap" + list[j] + " with " + list[j + 1]);
                    int temp = list[j + 1];
                    list[j + 1] = list[j];
                    list[j] = temp;
                    needNextPass = true;
                }
            }
            if (needNextPass == false) {
                System.out.println("Array may be sorted and next pass not needed");
                break;
            }
            System.out.println("List after the "+ i + " sort: ");
            for (int item: list) {
                System.out.print(item + " ");
            }
        }
    }
}
