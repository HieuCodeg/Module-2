public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 2, -5, 8, -6};
        int result;
        boolean check = true;
        int n;
        if ((arr.length - 1) % 2 == 0 ) {
            n = arr.length - 1;
        } else {
            n = arr.length - 2;
        }
        for (int i = n; i >= 0; i -= 2) {
            if (arr[i] % 2 != 0) {
                result = arr[i];
                System.out.println("Số lẻ cuối cùng ở vị trí chẵn là: " + result);
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("Không tìm thấy số lẻ ở vị trí chẵn");
        }
    }
}