package them_phan_tu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] array;
        Scanner sc = new Scanner(System.in);

        array = new int[100];
        int i = 0;
        while (i < 5) {
            System.out.print("Nhập phần tử " + (i + 1) + ": ");
            array[i] = sc.nextInt();
            i++;
        }
        int length = 5;
        System.out.printf("%-20s", "Phần tử của mảng: ");
        for (int j = 0; j < length; j++) {
            System.out.print(array[j] + "\t");
        }

        int index;
        System.out.println("\nNhập phần tử cần chèn: ");
        int x = sc.nextInt();
        do {
            System.out.println("\nNhập vị trí chèn: ");
            index = sc.nextInt();
            if ((index > length - 1 || index < 0)) {
                System.out.println("Vị trí không thỏa mãn");
            }
        } while (index > length - 1 || index < 0);


        length++;
        for (int j = length - 1; j > index; j--) {
            array[j] = array[j - 1];
        }
        array[index] = x;

        System.out.printf("%-20s", "Phần tử của mảng : ");
        for (int j = 0; j < length; j++) {
            System.out.print(array[j] + "\t");
        }


    }
}
