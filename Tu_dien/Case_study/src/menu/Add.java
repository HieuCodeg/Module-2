package menu;

import structor.Define;
import structor.Dictionary;
import structor.Entities;
import structor.Meaning;

import java.util.Scanner;

public class Add {
    static Scanner sc = new Scanner(System.in);

    public static void add(Dictionary dictionary) {
        System.out.println("Nhập từ: ");
        String word = sc.nextLine();
        Entities newEntry = new Entities(word);
        System.out.println("Nhập phiên âm: ");
        newEntry.setPronounce(sc.nextLine());

        addDefine(newEntry);

        dictionary.add(newEntry.getName(), newEntry);
        System.out.println("Đã thêm " + newEntry.getName());
    }

    public static void addDefine(Entities newEntry) {
        do {
            System.out.println("Nhập định nghĩa:");
            String typeOfDefine = sc.nextLine();
            Define define = new Define(typeOfDefine);

            addMeaning(define);

            newEntry.setDefinesList(define);
            System.out.println("Bạn có muốn thêm định nghĩa: ");
            System.out.println("1. Có cho tôi thêm (or any key");
            System.out.println("2. Bỏ qua");
            int meaningChoose = 2;
            try {
                meaningChoose = Integer.parseInt(sc.nextLine());
            }catch (Exception e) {
                System.err.println(e.getMessage());
            }
            if (meaningChoose == 2) {
                break;
            }
        } while (true);

    }

    public static void addMeaning(Define define) {
        do {
            System.out.println("Nhập nghĩa của từ: ");
            String meaning = sc.nextLine();
            Meaning newMean = new Meaning(meaning);
            do {
                System.out.println("Bạn có muốn thêm ví dụ: ");
                System.out.println("1. Có cho tôi thêm (or any key");
                System.out.println("2. Bỏ qua");
                int exampleChoose = 2;
                try {
                    exampleChoose = Integer.parseInt(sc.nextLine());
                }catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                if (exampleChoose == 2)
                    break;
                System.out.println("Câu: ");
                String sentence1 = sc.nextLine();
                System.out.println("Nghĩa: ");
                String sentence2 = sc.nextLine();

                newMean.setExample(sentence1 + ": " + sentence2);
                System.out.println("Thêm câu ví dụ?");
            } while (true);
            define.setMeaning(newMean);
            System.out.println("Bạn có muốn thêm nghĩa: ");
            System.out.println("1. Có cho tôi thêm (or any key");
            System.out.println("2. Bỏ qua");
            int meaningChoose = 2;
            try {
                meaningChoose = Integer.parseInt(sc.nextLine());
            }catch (Exception e) {
                System.err.println(e.getMessage());
            }
            if (meaningChoose == 2) {
                break;
            }
        } while (true);

    }
}
