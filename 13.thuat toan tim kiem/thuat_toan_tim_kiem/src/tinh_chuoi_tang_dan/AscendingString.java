package tinh_chuoi_tang_dan;

import java.util.Scanner;

public class AscendingString {

    public static String findAcendingString(String arr) {
        String list = "";
        int count = 0;
        int max = 0;
        String result = "";
        for (int i = 0; i < arr.length(); i++) {
            list = "";
            list += arr.charAt(i);
            count = 1;
            for (int j = i + 1; j < arr.length(); j++) {
                if (arr.charAt(j) > list.charAt(list.length() - 1)) {
                    list += arr.charAt(j);
                    count++;
                }
            }
            if (count > max) {
                result = list;
                max = count;
            }
        }
        return result;
         /* Tính độ phức tạp bài toán:
            1 vòng lặp bên ngoài = n;
            1 vòng lặp bên trong = n -1;
            1 câu lệnh = 1;
            T(n) = n * (n - 1) + 1;
            t(n) = O(n^2) + O(n);
            t(n) = O(n^2);
            => Độ phức tạp bài toán này là O(n^2)
            */

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi: ");
        String list = sc.nextLine();
        System.out.println(findAcendingString(list));
    }
}
