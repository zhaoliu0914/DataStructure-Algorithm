package list;

import java.math.BigDecimal;

public class MyLinkedList<E> {

    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> previous;

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }
    }

    private Node<E> head;
    private Node<E> tail;

    private int size;

    public MyLinkedList() {
        this.size = 0;
        this.head = new Node<>();
        this.tail = new Node<>();
    }

    public void add(E value) {
        if (value != null) {
            Node<E> node = new Node<>();
            node.setElement(value);

            if (size == 0) {
                head.setNext(node);
                tail.setPrevious(node);

                node.setNext(tail);
                node.setPrevious(head);
            } else {
                Node<E> oldNode = tail.getPrevious();
                oldNode.setNext(node);

                node.setPrevious(oldNode);
                node.setNext(tail);

                tail.setPrevious(node);
            }

            size++;
        }
    }

    public boolean remove(int index) {
        if (index < 0 || index > size) {
            return false;
        }

        if (size > 0) {
            Node<E> oldNode = head.getNext();
            for (int i = 0; i < index; i++) {
                oldNode = oldNode.getNext();
            }

            Node<E> previousNode = oldNode.getPrevious();
            Node<E> nextNode = oldNode.getNext();

            previousNode.setNext(nextNode);
            nextNode.setPrevious(previousNode);

            size--;
        }

        return true;
    }

    public void set(int index, E value) {
        if (index < 0 || index > size || value == null) {
            return;
        }

        Node<E> currentNode = head.getNext();
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        currentNode.setElement(value);
    }

    public boolean removeByValue(E value) {
        if (value == null) {
            return false;
        }

        boolean exist = this.contains(value);
        if (exist == false) {
            return false;
        }

        int index = this.findByValue(value);

        remove(index);

        return true;
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            return null;
        }

        Node<E> currentNode = head.getNext();
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return (E) currentNode.getElement();
    }

    public int findByValue(E value) {
        if (value == null) {
            return -1;
        }

        Object temp;
        Node<E> currentNode = head.getNext();
        for (int i = 0; i < size; i++) {
            temp = currentNode.getElement();
            if (temp.equals(value)) {
                return i;
            }

            currentNode = currentNode.getNext();
        }

        return -1;
    }

    public boolean contains(E value) {
        if (value == null) {
            return false;
        }

        Object temp;
        Node<E> currentNode = head.getNext();
        for (int i = 0; i < size; i++) {
            temp = currentNode.getElement();
            if (temp.equals(value)) {
                return true;
            }

            currentNode = currentNode.getNext();
        }

        return false;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printList() {
        System.out.print("[");

        Object temp;
        int lastIndex = size - 1;
        Node<E> currentNode = head.getNext();
        for (int i = 0; i < size; i++) {
            temp = currentNode.getElement();
            System.out.print(temp);

            if (i != lastIndex) {
                System.out.print(", ");
            }

            currentNode = currentNode.getNext();
        }

        System.out.println("]");
    }

    /**
     * 移除链表中重复的节点
     * 不使用临时缓冲区
     */
    public void deleteDuplication() {
        if (head == null) {
            return;
        }

        Node<E> current = head.next;
        Node<E> runner;
        E currentElement;
        E runnerElement;
        while (current != null) {
            currentElement = current.element;

            runner = current.next;
            while (runner != null) {
                runnerElement = runner.element;

                if (currentElement.equals(runnerElement)) {
                    Node<E> previousNode = runner.previous;
                    Node<E> nextNode = runner.next;

                    previousNode.next = nextNode;
                    nextNode.previous = previousNode;

                    runner = nextNode;

                    size--;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }

    /**
     * 找出链表中倒数第K个节点
     *
     * @param k
     */
    public void findKthToLast(int k) {
        if (k <= 0) {
            return;
        }

        findKthNodeToLast(head.next, k);
    }

    private int findKthNodeToLast(Node<E> node, int k) {
        if (node == null || node.element == null) {
            return 0;
        }

        int count = findKthNodeToLast(node.next, k) + 1;
        if (count == k) {
            System.out.println(node.element);
        }
        return count;
    }

    /**
     * 以给定值 X 为基准，将链表分割成两部分，
     * 所有小于 X 的节点排在 大于或者等于 X 的节点之前
     *
     * @param x
     */
    public void splitLinkedListByX(int x) {
        if (head == null) {
            return;
        }

        BigDecimal xBigDecimal = new BigDecimal(x);

        Node<E> beforeNodeStart = null;
        Node<E> beforeNodeEnd = null;
        Node<E> afterNodeStart = null;
        Node<E> afterNodeEnd = null;

        Node<E> temp = head.next;
        E tempElement;
        BigDecimal tempBigDecimal;
        while (temp != null && temp.element != null) {
            tempElement = temp.element;
            tempBigDecimal = new BigDecimal(tempElement.toString());
            if (tempBigDecimal.compareTo(xBigDecimal) < 0) {
                if (beforeNodeStart == null) {
                    beforeNodeStart = new Node<>();
                    beforeNodeStart.element = tempElement;

                    beforeNodeEnd = new Node<>();

                    beforeNodeStart.next = beforeNodeEnd;
                } else {
                    beforeNodeEnd.element = tempElement;
                    beforeNodeEnd.next = new Node<>();

                    beforeNodeEnd = beforeNodeEnd.next;
                }
            } else {
                if (afterNodeStart == null) {
                    afterNodeStart = new Node<>();
                    afterNodeStart.element = tempElement;

                    afterNodeEnd = new Node<>();

                    afterNodeStart.next = afterNodeEnd;
                } else {
                    afterNodeEnd.element = tempElement;
                    afterNodeEnd.next = new Node<>();

                    afterNodeEnd = afterNodeEnd.next;
                }
            }

            temp = temp.next;
        }

        beforeNodeEnd.element = afterNodeStart.element;
        beforeNodeEnd.next = afterNodeStart.next;


        System.out.println(beforeNodeStart);
    }

    public void addLists() {
        Node<Integer> node1 = new Node<>();
        node1.element = 6;

        Node<Integer> node2 = new Node<>();
        node2.element = 1;

        Node<Integer> node3 = new Node<>();
        node3.element = 7;

        node1.next = node2;
        node2.next = node3;

        String result = combineElementAsStr(node1);

        System.out.println(result);
    }

    private String combineElementAsStr(Node<Integer> node) {
        if (node == null) {
            return "";
        }

        String currentElement = node.element.toString();
        String lastElement = combineElementAsStr(node.next);

        return currentElement + lastElement;
    }

    public Node<Integer> findBeginningOfLoop() {
        Node<Integer> node1 = new Node<>();
        node1.element = 1;

        Node<Integer> node2 = new Node<>();
        node2.element = 2;

        Node<Integer> node3 = new Node<>();
        node3.element = 3;

        Node<Integer> node4 = new Node<>();
        node4.element = 4;

        Node<Integer> node5 = new Node<>();
        node5.element = 5;

        Node<Integer> node6 = new Node<>();
        node6.element = 6;

        Node<Integer> node7 = new Node<>();
        node7.element = 7;

        Node<Integer> node8 = new Node<>();
        node8.element = 8;

        Node<Integer> node9 = new Node<>();
        node9.element = 9;

        Node<Integer> node10 = new Node<>();
        node10.element = 10;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node4;

        Node<Integer> slowRunner = node1;
        Node<Integer> fastRunner = node1;

        while (slowRunner != null && fastRunner != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
            // Check for NullPointException
            /*
            if (fastRunner != null) {
                fastRunner = fastRunner.next;
            }
             */

            if (slowRunner == fastRunner) {
                System.out.println("This is a loop linked list.");
                break;
            }
        }

        if (fastRunner == null || fastRunner.next == null) {
            System.out.println("This is not a loop linked list.");
        }

        slowRunner = node1;
        while (slowRunner != null && fastRunner != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;

            if (slowRunner == fastRunner) {
                System.out.println("The loop begins at " + slowRunner.element);
                return slowRunner;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(32);
        linkedList.add(14);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(10);
        linkedList.add(9);
        linkedList.add(20);
        linkedList.printList();

        //linkedList.deleteDuplication();
        //linkedList.printList();

        linkedList.findKthToLast(4);

        linkedList.splitLinkedListByX(10);

        linkedList.addLists();

        linkedList.findBeginningOfLoop();

        System.out.println(11 % 7);

        int a = 123456789;
        int b = 6;

        int c = a % 10000000;
        int d = a % 1000000;

        int e = c - d;

        int f = e / 1000000;

        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);
        System.out.println("f = " + f);

    }

}
