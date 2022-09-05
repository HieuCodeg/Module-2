package menu;

import structor.Define;
import structor.Dictionary;
import structor.Entities;

import java.util.Scanner;

public class Edit {
    static Scanner sc = new Scanner(System.in);
    public static void change(Dictionary dictionary) {
        System.out.println("Nhập từ cần sửa: ");
        String item = sc.nextLine();
        if (!dictionary.isExist(item)) {
            System.out.println("Từ không có trong chỉ mục");
            return;
        }
        Entities entry = dictionary.getValue(item);
        System.out.println("Nhập kiểu định nghĩa muốn bổ sung: ");
        String defineType = sc.nextLine();
        Define define = entry.getDefine(defineType);
        Add.addMeaning(define);
        dictionary.add(item, entry);
    }
}
