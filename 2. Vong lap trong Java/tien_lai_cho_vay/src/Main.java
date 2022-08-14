import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Số lượng tiền cho vay: ");
        double loan = sc.nextDouble();
        System.out.println("Lãi suất: ");
        double interestRate = sc.nextDouble();
        System.out.println("Số tháng: ");
        int month = sc.nextInt();
        double result = 0;

        for (int i = 0; i < month; i++) {
            result += loan * (interestRate/100)/12 * month;
        }

        System.out.println("Tiền lãi: " + result);


    }
}
