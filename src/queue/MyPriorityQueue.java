package queue;

import java.math.BigDecimal;

public class MyPriorityQueue<E> {

    private int capacity;
    private int size;
    private Object[] elements;

    public MyPriorityQueue() {
        this.capacity = 11;
        this.size = 0;
        elements = new Object[this.capacity];
    }

    public MyPriorityQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        elements = new Object[capacity];
    }

    public boolean insert(E key) {
        if (key == null) {
            System.out.println("input parameter is null.");
            return false;
        }

        if (isFull()) {
            System.out.println("Priority Queue is Full.");
            return false;
        }

        if (this.size == 0) {
            this.elements[0] = key;
            this.size++;
        } else {
            this.elements[this.size] = key;
            this.size++;

            percolateUp();
        }

        return true;
    }

    public E deleteMinimum() {
        if (this.size == 0) {
            System.out.println("This Priority Queue is empty.");
            return null;
        }

        E minimumKey = (E) this.elements[0];
        this.size--;

        percolateDown();

        return minimumKey;
    }

    private void percolateUp() {
        int childIndex = this.size - 1;
        E childKey = (E) this.elements[childIndex];
        BigDecimal childKeyAsDecimal = new BigDecimal(childKey.toString());

        int parentIndex = (childIndex - 1) / 2;
        E parentKey = (E) this.elements[parentIndex];
        BigDecimal parentKeyAsDecimal = new BigDecimal(parentKey.toString());

        while (childKeyAsDecimal.compareTo(parentKeyAsDecimal) < 0) {
            // swap childKey and parentKey.
            this.elements[parentIndex] = childKey;
            this.elements[childIndex] = parentKey;

            childIndex = parentIndex;
            childKey = (E) this.elements[childIndex];
            childKeyAsDecimal = new BigDecimal(childKey.toString());

            parentIndex = (childIndex - 1) / 2;
            parentKey = (E) this.elements[parentIndex];
            parentKeyAsDecimal = new BigDecimal(parentKey.toString());
        }
    }

    private void percolateDown() {
        if (this.size <= 0) {
            return;
        }

        int lastedIndex = this.size;
        E lastedKey = (E) this.elements[lastedIndex];
        BigDecimal lastedKeyAsDecimal = new BigDecimal(lastedKey.toString());

        int parentIndex = 0;

        int childIndex;
        E childKey;
        int rightChildIndex = (parentIndex + 1) * 2;
        E rightChildKey = null;
        BigDecimal rightChildKeyAsDecimal = null;
        if (rightChildIndex <= this.size) {
            rightChildKey = (E) this.elements[rightChildIndex];
            rightChildKeyAsDecimal = new BigDecimal(rightChildKey.toString());
        }

        int leftChildIndex = rightChildIndex - 1;
        E leftChildKey = null;
        BigDecimal leftChildKeyAsDecimal = null;
        if (leftChildIndex <= this.size) {
            leftChildKey = (E) this.elements[leftChildIndex];
            leftChildKeyAsDecimal = new BigDecimal(leftChildKey.toString());
        }

        childIndex = leftChildIndex;
        childKey = leftChildKey;
        if (rightChildIndex <= this.size && rightChildKeyAsDecimal.compareTo(leftChildKeyAsDecimal) < 0) {
            childIndex = rightChildIndex;
            childKey = rightChildKey;
        }

        BigDecimal childKeyAsDecimal = new BigDecimal(childKey.toString());

        while (childIndex <= this.size && lastedKeyAsDecimal.compareTo(childKeyAsDecimal) > 0) {

            // Swap the smallest child key with parent key
            this.elements[parentIndex] = childKey;

            parentIndex = childIndex;

            rightChildIndex = (parentIndex + 1) * 2;
            if (rightChildIndex <= this.size) {
                rightChildKey = (E) this.elements[rightChildIndex];
                rightChildKeyAsDecimal = new BigDecimal(rightChildKey.toString());
            }
            leftChildIndex = rightChildIndex - 1;
            if (leftChildIndex <= this.size) {
                leftChildKey = (E) this.elements[leftChildIndex];
                leftChildKeyAsDecimal = new BigDecimal(leftChildKey.toString());
            }

            childIndex = leftChildIndex;
            childKey = leftChildKey;
            if (rightChildIndex <= this.size && rightChildKeyAsDecimal.compareTo(leftChildKeyAsDecimal) < 0) {
                childIndex = rightChildIndex;
                childKey = rightChildKey;
            }

            childKeyAsDecimal = new BigDecimal(childKey.toString());
        }

        this.elements[parentIndex] = lastedKey;
    }

    public E findMinimum() {
        if (this.size == 0) {
            System.out.println("This Priority Queue is empty.");
            return null;
        }

        E minimumKey = (E) this.elements[0];

        return minimumKey;
    }

    public boolean buildHeap(E[] buildArray) {
        if (buildArray == null) {
            return false;
        }

        for (E temp : buildArray) {
            this.insert(temp);
        }

        return true;
    }

    /*
    public boolean delete(E key) {

    }

    public boolean decreaseKey(E key, int decrement) {

    }

    public boolean increaseKey(E key, int increment) {

    }
    */

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }

        return false;
    }

    public boolean isFull() {
        if (this.size == this.capacity) {
            return true;
        }

        return false;
    }

    public void printPriorityQueue() {
        System.out.print("[");
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.elements[i]);
            if (i < this.size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        MyPriorityQueue<Integer> priorityQueue = new MyPriorityQueue<>();

        priorityQueue.insert(21);
        System.out.println("insert 21");
        priorityQueue.printPriorityQueue();

        priorityQueue.insert(65);
        System.out.println("insert 65");
        priorityQueue.printPriorityQueue();


        priorityQueue.insert(26);
        System.out.println("insert 26");
        priorityQueue.printPriorityQueue();

        priorityQueue.insert(13);
        System.out.println("insert 13");
        priorityQueue.printPriorityQueue();

        priorityQueue.insert(31);
        System.out.println("insert 31");
        priorityQueue.printPriorityQueue();

        priorityQueue.insert(24);
        System.out.println("insert 24");
        priorityQueue.printPriorityQueue();

        priorityQueue.insert(32);
        System.out.println("insert 32");
        priorityQueue.printPriorityQueue();

        priorityQueue.insert(16);
        System.out.println("insert 16");
        priorityQueue.printPriorityQueue();

        priorityQueue.insert(19);
        System.out.println("insert 19");
        priorityQueue.printPriorityQueue();

        priorityQueue.insert(68);
        System.out.println("insert 68");
        priorityQueue.printPriorityQueue();

        priorityQueue.insert(14);
        System.out.println("insert 14");
        priorityQueue.printPriorityQueue();

        priorityQueue.insert(6);
        System.out.println("insert 6");
        priorityQueue.printPriorityQueue();

        System.out.println("------------------Start to Delete--------------------");

        priorityQueue.deleteMinimum();
        System.out.println("deleteMinimum");
        priorityQueue.printPriorityQueue();

        priorityQueue.deleteMinimum();
        System.out.println("deleteMinimum");
        priorityQueue.printPriorityQueue();

        priorityQueue.deleteMinimum();
        System.out.println("deleteMinimum");
        priorityQueue.printPriorityQueue();

        priorityQueue.deleteMinimum();
        System.out.println("deleteMinimum");
        priorityQueue.printPriorityQueue();

        priorityQueue.deleteMinimum();
        System.out.println("deleteMinimum");
        priorityQueue.printPriorityQueue();

        priorityQueue.deleteMinimum();
        System.out.println("deleteMinimum");
        priorityQueue.printPriorityQueue();

        priorityQueue.deleteMinimum();
        System.out.println("deleteMinimum");
        priorityQueue.printPriorityQueue();

        priorityQueue.deleteMinimum();
        System.out.println("deleteMinimum");
        priorityQueue.printPriorityQueue();

        priorityQueue.deleteMinimum();
        System.out.println("deleteMinimum");
        priorityQueue.printPriorityQueue();

        priorityQueue.deleteMinimum();
        System.out.println("deleteMinimum");
        priorityQueue.printPriorityQueue();

        priorityQueue.deleteMinimum();
        System.out.println("deleteMinimum");
        priorityQueue.printPriorityQueue();

    }

}
