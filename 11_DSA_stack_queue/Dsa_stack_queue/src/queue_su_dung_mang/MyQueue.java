package queue_su_dung_mang;

public class MyQueue {
    public int capacity;
    public int[] queueArr;
    public int head = 0;
    public int tail = 0;
    public int currentSize;

    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[queueSize];
    }

    public boolean isQueueFull() {
        if (currentSize == capacity) {
            return true;
        }
        return false;
    }

    public boolean isQueueEmpty() {
        boolean status = false;
        if (currentSize == 0) {
           status = true;
        }
        return status;
    }

    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Overflow ! Unable to add element: " + item);
        } else {
            queueArr[tail] = item;
            currentSize++;
            tail++;
            if (tail == capacity ) {
                tail = 0;
            }
            System.out.println("Element " + item + " is pushed to Queue !");
        }
    }

    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow ! Unable to remove element from Queue");
        } else {
            System.out.println("Pop operation done ! removed: " + queueArr[head]);
            head++;
            if (head == capacity)
                head = 0;
            currentSize--;
        }
    }
}
