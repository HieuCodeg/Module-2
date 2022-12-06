package phuong_thuc_linkedlist;

import linklist_don_gian.MyLinkList;

public class MyLinkedList<E> {

    private int numNode = 0;
    private Node head;
    private final E EMPTY_VALUE = null;

    private class Node {
        private Node next;
        private E data;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }
    }

    public MyLinkedList() {
    }

    public void add(int index, E element) {
        if (index < 0 || index > numNode) {
            System.out.println("index invalid");
            return;
        }
        if (index == numNode) {
            addLast(element);
            return;
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        Node temp = head;
        Node holder;
        int count = 1;
        while (count < index) {
            temp = temp.next;
            count++;
        }

        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNode++;
    }

    public boolean add(E o) {
        if (numNode == 0) {
            Node newNode = new Node(o);
            head = newNode;
            numNode++;
            return true;
        }
        addLast(o);
        return true;
    }

    public void addFirst(E e) {
        Node first = head;
        head = new Node(e);
        head.next = first;
        numNode++;
    }

    public void addLast(E e) {
        Node temp = head;

        for (int i = 0; i < numNode && temp.next != null; i++) {
            temp = temp.next;
        }
        temp.next = new Node(e);
        numNode++;
    }

    public E remove(int index) {
        if (index < 0 || index > numNode) {
            System.out.println("index invalid");
            return EMPTY_VALUE;
        }
        if (index == 0) {
            Node temp = head.next;
            head = temp;
            numNode--;
            return temp.getData();
        }
        if (index == numNode) {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node result = temp.next;
            temp.next = null;
            numNode--;
            return result.getData();
        }
        Node temp = head;
        Node holder;
        Node result;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        result = temp.next;
        holder = result.next;
        temp.next = holder;
        numNode--;
        return (E) result.getData();
    }

    public boolean remove(Object o) {
        if (o == null) {
            return true;
        }
        Node temp = head;
        for (int i = 0; i < numNode; i++) {
            if (temp == o) {
                remove(i);
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int size() {
        return numNode;
    }

    public Object clone() {
        MyLinkedList<E> newList = new MyLinkedList<>();
        newList.head = head;
        for (Node x = head; x != null; x = x.next) {
            newList.add(x.getData());
        }
        return newList;
    }

    public boolean contains(E o) {
        Node temp = head;
        for (int i = 0; i < numNode; i++) {
            if (temp == o) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E o) {
        Node temp = head;
        for (int i = 0; i < numNode; i++) {
            if (temp.getData() == o) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public E get(int i) {
        Node temp = head;
        for (int j = 0; j < i; j++) {
            temp = temp.next;
        }
        return (E) temp.getData();
    }

    public E getFirst() {
        Node temp = head;
        return (E) temp.getData();
    }

    public E getLast() {
        Node temp = head;
        for (int i = 0; i < numNode && temp.next != null; i++) {
            temp = temp.next;
        }
        return (E) temp.getData();
    }

    public void clear() {
        head = null;
    }

    public void printList() {
        System.out.print("List: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

}
