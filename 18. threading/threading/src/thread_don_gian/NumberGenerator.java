package thread_don_gian;

public class NumberGenerator implements Runnable {
    private String name;

    public NumberGenerator(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Generrator " + name + " printing the count " + i);
                System.out.println(hashCode());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("my thread interrupted");
        }
        System.out.println("Generrator " + name + " run is over");
    }
}
