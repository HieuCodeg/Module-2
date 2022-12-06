package thread_don_gian;

public class Main {
    public static void main(String[] args) {

        NumberGenerator o1 = new NumberGenerator("Gen1");
        NumberGenerator o2 = new NumberGenerator("Gen2");

        Thread num1 = new Thread(o1);
        Thread num2 = new Thread(o2);

        num1.setPriority(Thread.MIN_PRIORITY);
        num2.setPriority(Thread.MAX_PRIORITY);

        num1.start();
        num2.start();
    }
}
