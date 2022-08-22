package tinh_do_phuc_tap_thuat_toan;

import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String inputString = sc.nextLine();
        int[] frequentChar = new int[255];                       // {1}
        for (int i = 0; i < inputString.length(); i++) {        // {2}
            int ascii = inputString.charAt(i);                   // {3}
            frequentChar[ascii] += 1;                            // {4}
        }

        int max = 0;                                              // {5}
        char character = (char) 255;                             // {6}
        for (int j = 0; j < 255; j++) {                           // {7}
            if (frequentChar[j] > max) {                          // {8}
                max = frequentChar[j];                           // {9}
                character = (char) j;                            // {10}
            }
        }
        System.out.println("The most appearing letter is '" +
                character + "' with a frequency of " + max + " times");
    }

}
