package minh_hoa_sap_xep_chen;

import java.util.Scanner;

public class InsertionSortByStep {

//    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

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
        insertionSortByStep(list);
    }

    public static void insertionSortByStep(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            int j = i - 1;
            System.out.println("insert " + list[i] +
                    " into a sorted sublist list[0..." + (i - 1) + "]");
            while (j >= 0 && key < list[j]) {
                list[j + 1] = list[j];
                System.out.println("list["+ (j+1)+ "] replace by [" + j + "]");
                j--;
            }
            list[j + 1] = key;
            System.out.println("List after insert " +list[j+1]+": ");
            for (int item:list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
