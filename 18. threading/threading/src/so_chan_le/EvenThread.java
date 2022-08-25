package so_chan_le;

public class EvenThread extends Thread{

    public EvenThread(String name) {
        super(name);
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i += 2) {
                System.out.println(getName() + " printing the count " + i);
                Thread.sleep(15);
            }
        } catch (InterruptedException e) {
            System.out.println("my thread interrupted");
        }
        System.out.println( getName() + " run is over");
    }


}
