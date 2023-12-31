package tree;

public class MyTree<E> {

    private static class Node<E> {
        private E element;
        private Node<E> firstChild;
        private Node<E> nextSibling;

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getFirstChild() {
            return firstChild;
        }

        public void setFirstChild(Node<E> firstChild) {
            this.firstChild = firstChild;
        }

        public Node<E> getNextSibling() {
            return nextSibling;
        }

        public void setNextSibling(Node<E> nextSibling) {
            this.nextSibling = nextSibling;
        }
    }

    private Node head;

    public MyTree() {
        head = new Node<>();
    }

    public boolean insert(String path) {
        if (path == null || path.isBlank()) {
            return false;
        }

        String[] directories = path.split("/");
        int dirSize = directories.length;

        String insertData = directories[dirSize - 1];

        String parentData = null;
        if (dirSize >= 3) {
            parentData = directories[dirSize - 2];
        }

        if (parentData == null || head == null) {
            Node<String> rootNode = new Node<>();
            rootNode.setElement(insertData);

            head.setFirstChild(rootNode);
        } else {

            Node<String> parentNode = findParentNodeByPath(directories);
            if (parentNode == null) {
                return false;
            }

            Node<String> childNode = new Node<>();
            childNode.setElement(insertData);

            int count = numberOfChild(parentNode);
            if (count == 0) {

                parentNode.setFirstChild(childNode);
            } else {
                Node<String> lastSiblingNode = findTheLastSibling(parentNode);

                lastSiblingNode.setNextSibling(childNode);
            }
        }

        return true;
    }

    public boolean remove(String path) {
        if (path == null || path.isBlank()) {
            return false;
        }

        String[] directories = path.split("/");
        int dirSize = directories.length;

        String deleteData = directories[dirSize - 1];

        String parentData = null;
        if (dirSize >= 3) {
            parentData = directories[dirSize - 2];
        }

        if (parentData == null) {
            head.setFirstChild(null);
        } else {
            Node<String> parentNode = findParentNodeByPath(directories);
            if (parentNode == null) {
                return false;
            }

            int count = numberOfChild(parentNode);
            if (count == 0) {
                return false;
            } else if (count == 1) {
                parentNode.setFirstChild(null);
            } else {
                Node<String> deleteNode = findMatchedSibling(parentNode.getFirstChild(), deleteData);

                Node<String> previousNode = findPreviousSibling(parentNode.getFirstChild(), deleteData);

                if (deleteNode.getNextSibling() == null) {
                    previousNode.setNextSibling(null);
                } else {
                    previousNode.setNextSibling(deleteNode.getNextSibling());
                }

            }
        }

        return true;
    }

    public void preorderTraversal(Node<String> node, int depth) {


    }

    public void postorderTraversal() {

    }

    private void printNodeElement(Node<String> node, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print('\t');
        }

        System.out.println(node.getElement());
    }

    public Node<String> findParentNodeByPath(String[] directories) {
        if (directories == null || directories.length == 0) {
            return null;
        }

        Node<String> rootNode = head.getFirstChild();

        String rootName = rootNode.getElement();
        String inputRoot = directories[1];

        if (!rootName.equals(inputRoot)) {
            return null;
        }

        Node<String> tempSiblingNode;
        String matchName;
        Node<String> matchedNode = rootNode;
        for (int i = 2; i < directories.length - 1; i++) {
            tempSiblingNode = matchedNode.getFirstChild();
            matchName = directories[i];

            matchedNode = findMatchedSibling(tempSiblingNode, matchName);
        }

        return matchedNode;
    }

    private Node<String> findMatchedSibling(Node<String> firstSibling, String matchName) {
        Node<String> matchedNode = firstSibling;
        String tempName = matchedNode.getElement();

        while (!tempName.equals(matchName)) {
            matchedNode = matchedNode.getNextSibling();
            tempName = matchedNode.getElement();
        }

        return matchedNode;
    }

    private int numberOfChild(Node<String> node) {
        Node<String> childNode = node.getFirstChild();
        if (childNode == null) {
            return 0;
        }

        int count = 1;
        while (childNode.getNextSibling() != null) {
            count++;

            childNode = childNode.getNextSibling();
        }

        return count;
    }

    private Node<String> findTheLastSibling(Node<String> parentNode) {
        Node<String> siblingNode = parentNode.getFirstChild();
        if (siblingNode == null) {
            return siblingNode;
        }

        while (siblingNode.getNextSibling() != null) {
            siblingNode = siblingNode.getNextSibling();
        }

        return siblingNode;
    }

    private Node<String> findPreviousSibling(Node<String> childNode, String name) {
        Node<String> previousNode = childNode;
        Node<String> matchedNode = previousNode.getNextSibling();

        while (!matchedNode.getElement().equals(name)) {
            previousNode = matchedNode;
            matchedNode = matchedNode.getNextSibling();
        }

        return previousNode;
    }

    public static void main(String[] args) {

        MyTree<String> myTree = new MyTree<>();

        myTree.insert("/usr");
        //myTree.preorderTraversal(myTree.head.getFirstChild(), 0);

        myTree.insert("/usr/mark");

        myTree.insert("/usr/alex");

        myTree.insert("/usr/mark/book");

        myTree.insert("/usr/mark/course");

        myTree.insert("/usr/mark/book/ch1.r");


        myTree.insert("/usr/mark/book/ch2.r");

        myTree.insert("/usr/mark/course/cop3530");

        myTree.insert("/usr/alex/junk.c");

        myTree.insert("/usr/mark/book/ch3.r");

        myTree.insert("/usr/mark/junk.c");


    }

}
