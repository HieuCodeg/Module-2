package baitap;

import java.util.LinkedList;
import java.util.Queue;

public class QueueLinkedList {
    public static void main(String[] args) {
        Queue<Integer> list = new LinkedList<>();
        // offer() - Chèn phần tử đã chỉ định vào hàng đợi. Nếu tác vụ thành công,
        // offer() trả về true, nếu không nó sẽ trả về false.
        list.offer(1);
        list.offer(2);
        System.out.println(list.offer(3));
        System.out.println(list.offer(null));
        System.out.println("Queue: " + list);

        // Trả về đầu của hàng đợi. Trả về null nếu hàng đợi trống.
        int accessedNumber = list.peek();
        System.out.println("Truy cập phần tử: " + accessedNumber);

        // Trả về và loại bỏ phần đầu của hàng đợi. Trả về null nếu hàng đợi trống.
        int removedNumber = list.poll();
        System.out.println("Loại bỏ phần tử: " + removedNumber);

        System.out.println("Cập nhật Queue: " + list);
    }
}
