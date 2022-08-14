public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9, 10, 20 ,30};
        boolean check = true;
        for (int i = 1; i < arr.length; i += 2) {
            if (arr[i] % 2 == 0) {
                System.out.print(arr[i] + "  ");
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("Không có phần tử chẵn");
        }
    }
}