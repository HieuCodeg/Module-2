package tim_chuoi_lien_tiep;

import java.util.Scanner;

public class MaxString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào 1 chuỗi: ");
        String string = sc.nextLine();
        int index = 0;
        int max = 0;
        int count = 1;
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) > string.charAt(i - 1) && i < string.length() - 1) {
                count++;
                continue;
            }
            if (string.charAt(i) > string.charAt(i - 1) && i == string.length() - 1) {
                count++;
                if (count > max) {
                    max = count;
                    index = i - count + 1;
                    break;
                }
            }
            if (count > max) {
                max = count;
                index = i - count;
                count = 1;
            }
        }
        System.out.println(string.substring(index, index + max));
//        Độ phức tạp T(n) = O(n);
    }
}
