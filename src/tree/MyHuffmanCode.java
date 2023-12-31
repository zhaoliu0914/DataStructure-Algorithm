package tree;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MyHuffmanCode {

    /**
     * Node
     */
    private static class Node {
        private char data;
        private int frequency;

        public Node(char data, int frequency) {
            this.data = data;
            this.frequency = frequency;
        }
    }

    /**
     * comparator
     */
    private static class HuffmanComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.frequency - o1.frequency;
        }
    }

    public static void main(String[] args) {
        char[] charArray = {'a', 'e', 'i', 's', 't', 32, 10};
        int[] charFrequency = {10, 15, 12, 3, 4, 13, 1};

        HuffmanComparator comparator = new HuffmanComparator();
        PriorityQueue<Node> priorityQueue = new PriorityQueue(comparator);

        Node root;

        for(int i=0;i<charArray.length;i++){
            Node node = new Node(charArray[i], charFrequency[i]);
            priorityQueue.add(node);
        }

        BigDecimal bigDecimal = new BigDecimal("4.2");
        //bigDecimal.multiply();
        bigDecimal = bigDecimal.divide(new BigDecimal(2), RoundingMode.UP);

        System.out.println(bigDecimal);


    }
}
