import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int rate = 23386;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap gia tri tien do: ");
        int USD = sc.nextInt();

        int VND = USD * rate;
        System.out.println("Gia tri tien Viet la: " + VND + "VND");
    }
}