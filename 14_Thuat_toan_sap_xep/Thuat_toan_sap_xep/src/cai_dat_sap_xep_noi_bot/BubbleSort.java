package cai_dat_sap_xep_noi_bot;

public class BubbleSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void bubbleSort(int[] list) {
        boolean needNextPass = true;

        for (int i = 1; i < list.length & needNextPass; i++) {
            needNextPass = false;
            for (int j = 0; j < list.length - i; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j + 1];
                    list[j + 1] = list[j];
                    list[j] = temp;
                    needNextPass = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int item: list) {
            System.out.print(item + " ");
        }
        bubbleSort(list);
        System.out.println();
        for (int item: list) {
            System.out.print(item + " ");
        }
    }
}
