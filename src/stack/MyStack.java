package stack;

public class MyStack<E> {
    private int size;
    private int capacity = 16;

    private Object[] elements;

    public MyStack() {
        this.size = 0;
        this.elements = new Object[capacity];
    }

    public void push(E value) {
        if (value != null) {
            elements[size] = value;

            size++;

            if (size == capacity) {
                capacity = capacity + 20;

                Object[] newElements = new Object[capacity];
                for (int i = 0; i < size; i++) {
                    newElements[i] = elements[i];
                }
                elements = newElements;
            }
        }
    }

    public E top() {
        if (size > 0) {
            E value = (E) elements[size - 1];
            elements[size - 1] = null;
            size--;

            return value;
        }
        return null;
    }

    public void pop() {
        this.top();
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void printStack() {
        System.out.print("[");
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                System.out.print(elements[i]);

                if (i != size - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println("]");
    }

}
