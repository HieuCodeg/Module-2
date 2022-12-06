package so_chan_le;

public class OldThread extends Thread {

    public OldThread(String name) {
        super(name);
    }

    public void run() {
        try {
            for (int i = 1; i < 10; i += 2) {
                System.out.println(getName() + " printing the count " + i);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println("my thread interrupted");
        }
        System.out.println( getName() + " run is over");
    }
}
