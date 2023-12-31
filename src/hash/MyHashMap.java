package hash;

public class MyHashMap<K, V> {

    private static class Node<K, V> {
        private int hash;
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private static int DEFAULT_INITIAL_CAPACITY = 16;

    private static int MAXIMUM_CAPACITY = 1000000;

    //private int size;

    private Node<K, V>[] table;

    public MyHashMap() {
        table = new Node[DEFAULT_INITIAL_CAPACITY];
        for (int i = 0; i < table.length; i++) {
            table[i] = new Node<>(-1, null, null, null);
        }
    }

    private int hash(K key) {
        String keyAsString = key.toString();
        char firstChar = keyAsString.charAt(0);
        char lastChar = keyAsString.charAt(keyAsString.length() - 1);

        return (firstChar + lastChar) % DEFAULT_INITIAL_CAPACITY;
    }

    public boolean put(K key, V value) {
        if (key == null) {
            System.out.println(key + " is null, unable to put into HashMap");
            return false;
        }

        int hashCode = this.hash(key);

        Node<K, V> node = new Node<>(hashCode, key, value, null);

        Node<K, V> headNode = table[hashCode];
        Node<K, V> tempNode = headNode.next;
        if (tempNode == null) {
            headNode.next = node;
        } else {

            Node<K, V> previousNode = tempNode;

            while (tempNode != null) {
                if (key.equals(tempNode.key)) {
                    tempNode.value = value;
                    return true;
                }

                previousNode = tempNode;
                tempNode = tempNode.next;
            }

            previousNode.next = node;
        }

        return true;
    }

    public boolean remove(K key) {
        if (key == null) {
            System.out.println(key + " is null, unable to remove");
            return false;
        }

        int hashCode = this.hash(key);

        Node<K, V> headNode = table[hashCode];
        Node<K, V> tempNode = headNode.next;

        Node<K, V> previousNode = headNode;
        while (tempNode != null) {
            if (key.equals(tempNode.key)) {
                previousNode.next = tempNode.next;

                return true;
            }

            previousNode = tempNode;
            tempNode = tempNode.next;
        }

        return false;
    }

    public V get(K key) {
        if (key == null) {
            System.out.println(key + " is null, unable to find");
            return null;
        }

        int hashCode = this.hash(key);

        Node<K, V> headNode = table[hashCode];
        Node<K, V> tempNode = headNode.next;

        while (tempNode != null) {
            if (key.equals(tempNode.key)) {

                return tempNode.value;
            }

            tempNode = tempNode.next;
        }

        return null;
    }

    private Node<K, V> getNodeByKey(K key) {
        if (key == null) {
            return null;
        }

        int hashCode = this.hash(key);

        Node<K, V> headNode = table[hashCode];
        Node<K, V> tempNode = headNode.next;

        while (tempNode != null) {
            if (key.equals(tempNode.key)) {

                return tempNode;
            }

            tempNode = tempNode.next;
        }

        return null;
    }

    public void printHashMap() {
        System.out.print("{");

        Node<K, V> headNode;
        Node<K, V> tempNode;
        for (int i = 0; i < table.length; i++) {
            System.out.print("[");
            headNode = table[i];
            tempNode = headNode.next;
            while (tempNode != null) {
                System.out.print("(" + tempNode.key + ", " + tempNode.value + "), ");

                tempNode = tempNode.next;
            }
            System.out.print("]");
            if (i < table.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("}");
    }

    public static void main(String[] args) {
        MyHashMap<String, String> hashMap = new MyHashMap<>();

        hashMap.put("a", "b");
        System.out.println("Hash Code = " + hashMap.hash("a"));
        hashMap.printHashMap();

        hashMap.put("A", "b");
        System.out.println("Hash Code = " + hashMap.hash("A"));
        hashMap.printHashMap();

        hashMap.put("1", "3");
        System.out.println("Hash Code = " + hashMap.hash("1"));
        hashMap.printHashMap();

        hashMap.put("5565", "xvxcvxc");
        System.out.println("Hash Code = " + hashMap.hash("5565"));
        hashMap.printHashMap();

        hashMap.put("vbdfb", "12321");
        System.out.println("Hash Code = " + hashMap.hash("vbdfb"));
        hashMap.printHashMap();

        hashMap.put("1", "4");
        System.out.println("Hash Code = " + hashMap.hash("1"));
        hashMap.printHashMap();

        hashMap.put("a", "c");
        System.out.println("Hash Code = " + hashMap.hash("a"));
        hashMap.printHashMap();

        hashMap.remove("A");
        System.out.println("remove A");
        hashMap.printHashMap();

        hashMap.remove("a");
        System.out.println("remove a");
        hashMap.printHashMap();
    }


}
