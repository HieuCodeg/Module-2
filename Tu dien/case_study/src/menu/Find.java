package menu;

import structor.Dictionary;
import java.util.Scanner;

public class Find {
    static Scanner sc = new Scanner(System.in);
    public static void lookup(Dictionary dictionary) {
        System.out.println("Nhập từ cần tra: ");
        String item = sc.nextLine();
        if (dictionary.find(item) == null) {
            System.out.println("Từ chưa cập nhật!");
        } else {
            System.out.println(dictionary.find(item));
        }
    }
}
