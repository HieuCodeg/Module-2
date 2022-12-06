package menu;

import structor.Dictionary;

import java.util.Scanner;

public class Remove {
    static Scanner sc = new Scanner(System.in);
    public static void drop(Dictionary dictionary) {
        System.out.println("Nhập từ cần xóa: ");
        String item = sc.nextLine();
        if (!dictionary.isExist(item)) {
            System.out.println("Từ không có trong chỉ mục");
            return;
        }
        dictionary.remove(item);
        System.out.println("Đã xóa " + item);
    }
}
