package tree;

import java.math.BigDecimal;

public class MyBinarySearchTree<E> {

    private static class Node<E> {
        private E key;
        private Node<E> left;
        private Node<E> right;

        public Node(E key) {
            this.key = key;
        }
    }

    private Node<E> root;

    public MyBinarySearchTree() {
        this.root = null;
    }

    public boolean insert(E key) {
        if (key == null) {
            return false;
        }

        if (root == null) {
            root = new Node<>(key);
        } else {
            insertNode(root, key);
        }

        return true;
    }

    public boolean remove(E key) {
        if (key == null || root == null) {
            return false;
        }

        root = removeNode(root, key);

        return true;
    }

    /**
     * A recursive function to insert a new key in BinarySearchTree
     *
     * @param node
     * @param key
     * @return
     */
    private Node<E> insertNode(Node<E> node, E key) {

        // If the tree is empty, return a new node
        // Otherwise, recursive down the tree
        if (node == null) {
            return new Node<>(key);

        } else if (new BigDecimal(key.toString()).compareTo(new BigDecimal(node.key.toString())) < 0) {
            // If the key is smaller than node.key than looking for the left subtree
            // It will insert into left node when { new Node<>(key) } return
            node.left = insertNode(node.left, key);

        } else if (new BigDecimal(key.toString()).compareTo(new BigDecimal(node.key.toString())) > 0) {
            // If the key is greater than node.key than looking for the right subtree
            // It will insert into right node when { new Node<>(key) } return
            node.right = insertNode(node.right, key);
        }

        // duplicated key will not be accepted.

        // return the (unchanged) node pointer
        return node;
    }

    /**
     * A recursive function to delete an existing key in BinarySearchTree
     * <p>
     * There are 2 cases:
     * 1 : node does not have any child, or node only have one child.
     * 2 : node has 2 child.
     *
     * @param node
     * @param key
     * @return
     */
    private Node<E> removeNode(Node<E> node, E key) {

        // recursive down the tree
        if (new BigDecimal(key.toString()).compareTo(new BigDecimal(node.key.toString())) < 0) {
            // If the key is smaller than node.key than looking for the left subtree
            // It will update the left node
            node.left = removeNode(node.left, key);

        } else if (new BigDecimal(key.toString()).compareTo(new BigDecimal(node.key.toString())) > 0) {
            // If the key is greater than node.key than looking for the right subtree
            // It will update the right node
            node.right = removeNode(node.right, key);

        } else {
            // Case 1 :
            // node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Case 2 :
            // node with two children: Get the inorder successor (smallest in the right subtree)
            E smallestInRight = smallestKeyInRightSubtree(node.right);

            // Copy the inorder successor's data (smallest in the right subtree) to this node
            node.key = smallestInRight;

            // Delete the inorder successor
            node.right = removeNode(node.right, smallestInRight);
        }

        return node;
    }

    private E smallestKeyInRightSubtree(Node<E> node) {
        E smallestKey = node.key;

        while (node != null) {
            smallestKey = node.key;

            node = node.left;
        }

        return smallestKey;
    }

    /**
     * 先序遍历 preorder traversal
     */
    public void preorderTraversal() {
        if (root != null) {
            preorderTraversalNode(root, 0);
        }

    }

    /**
     * 先序遍历 preorder traversal
     * <p>
     * 在先序遍历中，对节点的处理工作是在它子节点被处理之前(pre)进行的。
     * <p>
     * The preorder traversal is a topologically sorted one,
     * because a parent node is processed before any of its child nodes is done.
     * <p>
     * step 1 : print or process the current node
     * step 2 : Recursively traverse the current node's left subtree.
     * step 3 : Recursively traverse the current node's right subtree.
     *
     * @param node
     * @param indent
     */
    private void preorderTraversalNode(Node<E> node, int indent) {
        if (node != null) {
            for (int i = 0; i < indent; i++) {
                System.out.print("\t");
            }
            System.out.println(node.key);

            preorderTraversalNode(node.left, indent + 1);
            preorderTraversalNode(node.right, indent + 1);
        }

    }

    /**
     * 后续遍历 postorder traversal
     */
    public void postorderTraversal() {
        if (root != null) {
            postorderTraversalNode(root, 0);
        }
    }

    /**
     * 后续遍历 postorder traversal
     * <p>
     * 在后续遍历中，对节点的处理工作是在它子节点被处理之后(post)进行的。
     * <p>
     * step 1 : Recursively traverse the current node's left subtree.
     * step 2 : Recursively traverse the current node's right subtree.
     * step 3 : print or process the current node
     *
     * @param node
     * @param indent
     */
    private void postorderTraversalNode(Node<E> node, int indent) {
        if (node != null) {
            postorderTraversalNode(node.left, indent + 1);
            postorderTraversalNode(node.right, indent + 1);

            for (int i = 0; i < indent; i++) {
                System.out.print("\t");
            }
            System.out.println(node.key);
        }
    }

    /**
     * 中序遍历 inorder traversal
     */
    public void inorderTraversal() {
        if (root != null) {
            inorderTraversalNode(root, 0);
        }
    }

    /**
     * 中序遍历 inorder traversal
     * <p>
     * 在中序遍历中，先处理左子节点，再处理当前节点，然后再处理右节点
     * <p>
     * step 1 : Recursively traverse the current node's left subtree.
     * step 2 : print or process the current node
     * step 3 : Recursively traverse the current node's right subtree.
     *
     * @param node
     * @param indent
     */
    private void inorderTraversalNode(Node<E> node, int indent) {
        if (node != null) {
            inorderTraversalNode(node.left, indent + 1);

            for (int i = 0; i < indent; i++) {
                System.out.print("\t");
            }
            System.out.println(node.key);

            inorderTraversalNode(node.right, indent + 1);
        }
    }

    public static void main(String[] args) {

        MyBinarySearchTree<Integer> binarySearchTree = new MyBinarySearchTree<>();

        binarySearchTree.insert(11);
        binarySearchTree.insert(7);
        binarySearchTree.insert(3);
        binarySearchTree.insert(9);
        binarySearchTree.insert(18);
        binarySearchTree.insert(26);
        binarySearchTree.insert(15);
        binarySearchTree.insert(14);
        binarySearchTree.insert(16);

        binarySearchTree.preorderTraversal();

    }

}
