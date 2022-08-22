package phuong_thuc_arraylist;


import java.util.ArrayList;
import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private static final Object[] DEFAULT_ELEMENT = {};

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public void add(int index, E element) {
        size++;
        if (size > elements.length) {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];

        }
        elements[index] = element;
    }

    public boolean add(E o) {
        if (size == elements.length) {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
        elements[size++] = o;
        return true;
    }

    public E remove(int index) {
        if (index > size || index < 0) {
            System.out.println("index invalid");
            return (E) DEFAULT_ELEMENT;
        }
        E element = (E) elements[index];
        for (int i = index; i <= size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return element;
    }

    public int size() {
        return size;
    }

    public Object clone() {
        MyList<E> v = new MyList<>();
        v.elements = Arrays.copyOf(elements, size);
        v.size = size;
        return v;
    }

    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == o)
                return true;
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == o)
                return i;
        }
        return -1;
    }


    public void ensureCapacity(int minCapacity) {
        if (size != 0 && minCapacity > size)
            size = minCapacity;
    }

    public E get(int i) {
        if (i > size || i < 0) {
            System.out.println("index invalid");
            return (E) DEFAULT_ELEMENT;
        }
        return (E) elements[i];
    }

    public void clear() {
        for (int i = 0; i < size; i++)
            elements[i] = null;
        size = 0;
    }

    public void print() {
        System.out.print("List: ");
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }
}
