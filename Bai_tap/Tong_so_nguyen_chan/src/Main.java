public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 2, -5, 8, -6};
        int result = 0;
        for (int item: arr) {
            if (item > 0 && item % 2 == 0) {
                result += item;
            }
        }
        System.out.println("Tổng các số dương chẵn là: " + result);
    }
}