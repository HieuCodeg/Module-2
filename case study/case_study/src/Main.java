import menu.Add;
import menu.Edit;
import menu.Find;
import menu.Remove;
import structor.Dictionary;

import java.util.Scanner;

import static menu.Show.showMenu;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static Dictionary dictionary = new Dictionary();
    public static void main(String[] args) {

        int choose = 9;
        do {
            showMenu();
            try {
                choose = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            switch (choose) {
                case 1:
                    Add.add(dictionary);
                    break;
                case 2:
                    Find.lookup(dictionary);
                    break;
                case 3:
                    Edit.change(dictionary);
                    break;
                case 4:
                    Remove.drop(dictionary);
                    break;
                case 5:
                    dictionary.display();
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:
                    System.out.println("Thoát!!!");
                    break;
                default:
                    System.out.println("Nhập sai!!!");
                    break;
            }
        } while (choose != 9);
    }
}
