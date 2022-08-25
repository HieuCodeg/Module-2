package so_chan_le;

public class TestThread {
    public static void main(String[] args) throws InterruptedException {

        OldThread oldThread = new OldThread("OldThread");
        EvenThread evenThread = new EvenThread("EvenThread");

        oldThread.start();
        oldThread.join();
        evenThread.start();
    }
}
