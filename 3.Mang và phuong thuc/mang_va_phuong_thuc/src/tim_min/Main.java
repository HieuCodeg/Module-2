package tim_min;

public class Main {
    public static int minValue(int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[index]) {
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array = {1, 6, 2, 90, -22, 4, 5, 22};
        int index = minValue(array);
        System.out.println("Phần tử nhỏ nhất: " + array[index]);
    }
}
