import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số lượng số nguyên tố  in n = ");
        int n = sc.nextInt();
        int count = 0;
        int prime = 2;
        while (count < n) {
            System.out.println(prime);
            count++;
            prime++;
            while (true) {
                boolean check = true;
                for (int i = 2; i <= Math.sqrt(prime); i++) {
                    if (prime % i == 0) {
                        prime++;
                        check = false;
                        break;
                    }
                }
                if (check) {
                    break;
                }
            }

        }
    }
}