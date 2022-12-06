import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Draw the rectangle");
            System.out.println("2. Draw the square triangle");
            System.out.println("3. Draw the isosceles triangle");
            System.out.println("0. Exit!");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Draw the rectangle");
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 7; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Draw the square triangle");
                    System.out.println("Which square triangle do you want?");
                    System.out.println("1. Top-left");
                    System.out.println("2. Top-right");
                    System.out.println("3. Botton-left");
                    System.out.println("4. Botton-right");
                    System.out.println("Enter your choice: ");
                    int number = sc.nextInt();
                    int count;
                    switch (number) {
                        case 1:
                            System.out.println("Top-left");
                            for (int i = 7; i > 0 ; i--) {
                                for (int j = 1; j<=i; j++) {
                                    System.out.print("* ");
                                }
                                System.out.println();
                            }
                            break;
                        case 2:
                            System.out.println("Top-right");
                            count = 0;
                            for (int i = 7; i > 0; i--) {
                                for (int j = 1; j <= 7; j++) {
                                    if (j <= count) {
                                        System.out.print("  ");
                                    } else {
                                        System.out.print("* ");
                                    }
                                }
                                System.out.println();
                                count++;
                            }
                            break;
                        case 3:
                            System.out.println("Botton-left");
                            for(int i=1; i<=7; i++) {
                                for(int j=1; j<i; j++) {
                                    System.out.print("* ");
                                }
                                System.out.println();
                            }
                            break;
                        case 4:
                            System.out.println("Botton-right");
                            System.out.println("Top-right");
                            count = 1;
                            for (int i = 7; i > 0; i--) {
                                for (int j = 1; j <= 7; j++) {
                                    if (j <= count) {
                                        System.out.print("* ");
                                    } else {
                                        System.out.print("  ");
                                    }
                                }
                                System.out.println();
                                count++;
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Draw the isosceles triangle");
                    count = 1;
                    for (int i = 1; i < 7; i++) {
                        for (int j = 7; j >= 1; j--) {
                            if (j <= count) {
                                System.out.print("* ");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                        count++;
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }

    }
}