package tree;

import java.math.BigDecimal;

public class MyAVLTree<E> {

    private static class Node<E> {
        private E key;
        private int height;
        private Node<E> left;
        private Node<E> right;

        public Node(E key) {
            this.key = key;
            height = 1;
        }
    }

    public MyAVLTree() {

    }

    private Node<E> root;

    public boolean insert(E key) {
        if (key == null) {
            return false;
        }

        if (this.root == null) {
            this.root = new Node<>(key);
        } else {
            this.root = insertNode(this.root, key);
        }

        return true;
    }

    public boolean delete(E key) {
        if (key == null) {
            return false;
        }

        if (this.root != null) {
            this.root = deleteNode(this.root, key);
        }

        return true;
    }

    //public Node<E> find(Node<E> node, E key) {

    //}

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

        } else {
            // duplicated key will not be accepted.
            return node;
        }

        node = rebalance(node, key);

        return node;
    }

    private Node<E> deleteNode(Node<E> node, E key) {
        if (node == null) {
            return node;
        } else if (new BigDecimal(key.toString()).compareTo(new BigDecimal(node.key.toString())) < 0) {
            // If the key is smaller than node.key than looking for the left subtree
            // It will update the left node
            node.left = deleteNode(node.left, key);

        } else if (new BigDecimal(key.toString()).compareTo(new BigDecimal(node.key.toString())) > 0) {
            // If the key is greater than node.key than looking for the right subtree
            // It will update the right node
            node.right = deleteNode(node.right, key);
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
            node.right = deleteNode(node.right, smallestInRight);
        }

        node = rebalance(node, key);

        return node;
    }

    /**
     * Rebalance will have the following steps;
     * Step 1 : Update height of this node
     * Step 2 : Check the balance factor
     * <p>
     * If the balance factor <= 1 or >= -1, which means this subtree is balanced and there is nothing to do
     * return node.
     * <p>
     * If the balance factor > 1 or < -1, which means this subtree is unbalanced and need to be rotated.
     * There are 4 cases which need to be determined.
     * Case 1 : Left - Left Case.
     * #        The condition : balanceFactor > 1 and key < node.left.key
     * #        Just simply Right Rotation.
     * <p>
     * Case 2 : Right - Right Case.
     * #        The condition : balanceFactor < -1 and key > node.right.key
     * #        Just simply Left Rotation.
     * <p>
     * Case 3 : Left - Right Case.
     * #        The condition : balanceFactor > 1 and key > node.left.key
     * #        node.left Left Rotation first and then
     * #        node      Right Rotation.
     * <p>
     * Case 4 : Right - Left Case.
     * #        The condition : balanceFactor < -1 and key < node.right.key
     * #        node.right Right Rotation first and then
     * #        node       Left Rotation
     * <p>
     * Then execute Step 3:
     * Step 3 : rotation the subtree according to case (1,2,3,4).
     *
     * @param node
     * @param key
     * @return
     */
    private Node<E> rebalance(Node<E> node, E key) {

        // Update height of this node
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        // get the balance factor of this node and then
        // Check whether this node became unbalanced.
        int balanceFactor = checkBalanceFactor(node);

        //System.out.println("rebalance Method..... node.key = " + node.key + ", node.height = " + node.height + ", balanceFactor = " + balanceFactor + ", getHeight(node.left) = " + getHeight(node.left) + ", getHeight(node.right) = " + getHeight(node.right));

        // balanceFactor > 1 and key < node.left.key
        // Case 1 : Left - Left Case.
        if (balanceFactor > 1 && new BigDecimal(key.toString()).compareTo(new BigDecimal(node.left.key.toString())) < 0) {
            // Just simply Right Rotation.
            return rightRotation(node);
        }

        // balanceFactor < -1 and key > node.right.key
        // Case 2 : Right - Right Case.
        if (balanceFactor < -1 && new BigDecimal(key.toString()).compareTo(new BigDecimal(node.right.key.toString())) > 0) {
            // Just simply Left Rotation.
            return leftRotation(node);
        }

        // balanceFactor > 1 and key > node.left.key
        // Case 3 : Left - Right Case.
        if (balanceFactor > 1 && new BigDecimal(key.toString()).compareTo(new BigDecimal(node.left.key.toString())) > 0) {
            // node.left Left Rotation first
            node.left = leftRotation(node.left);

            // node Right Rotation.
            return rightRotation(node);
        }

        // balanceFactor < -1 and key < node.right.key
        // Case 4 : Right - Left Case.
        if (balanceFactor < -1 && new BigDecimal(key.toString()).compareTo(new BigDecimal(node.right.key.toString())) < 0) {
            // node.right Right Rotation first
            node.right = rightRotation(node.right);

            // node Left Rotation
            return leftRotation(node);
        }

        return node;
    }

    /**
     * A utility function to left rotate subtree rooted with node
     * the parameter is the first node of original subtree
     * In this example, the parameter node is 7.
     * <p>
     * The original subtree looks like:
     * #      7
     * #       \
     * #       11
     * #      /  \
     * #     9    16
     * <p>
     * It should be looked like this after left rotation:
     * #       11
     * #     /    \
     * #    7      16
     * #     \
     * #      9
     * <p>
     * There are 2 steps to perform left rotation
     * 1. perform rotation : left rotate subtree to according shape
     * 2. update heights : update heights of left node and middle node of subtree which are after performed rotation
     *
     * @param node this parameter is first node of subtree, for example: 7
     * @return
     */
    private Node<E> leftRotation(Node<E> node) {
        Node<E> middleNode = node.right;
        Node<E> middleLeftNode = middleNode.left;

        // step 1 : perform rotation
        middleNode.left = node;
        node.right = middleLeftNode;

        // step 2 : update heights - left node and middle node
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        middleNode.height = Math.max(getHeight(middleNode.left), getHeight(middleNode.right)) + 1;

        // return the middle node of new subtree
        return middleNode;
    }

    /**
     * A utility function to right rotate subtree rooted with node
     * the parameter is the first node of original subtree
     * In this example, the parameter node is 16.
     * <p>
     * The original subtree looks like:
     * #          16
     * #         /
     * #       11
     * #      /  \
     * #    9     12
     * <p>
     * It should be looked like this after right rotation:
     * #        11
     * #      /   \
     * #     9     16
     * #          /
     * #        12
     * <p>
     * There are 2 steps to perform right rotation
     * 1. perform rotation : right rotate subtree to according shape
     * 2. update heights : update heights of right node and middle node of subtree which are after performed rotation
     *
     * @param node this parameter is first node of subtree, for example: 16
     * @return
     */
    private Node<E> rightRotation(Node<E> node) {
        Node<E> middleNode = node.left;
        Node<E> middleRightNode = middleNode.right;

        // step 1 : perform rotation
        middleNode.right = node;
        node.left = middleRightNode;

        // step 2 : update heights - right node and middle node
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        middleNode.height = Math.max(getHeight(middleNode.left), getHeight(middleNode.right)) + 1;

        // return the middle node of new subtree
        return middleNode;
    }

    private int getHeight(Node<E> node) {
        if (node == null) {
            return 0;
        }

        return node.height;
    }

    private E smallestKeyInRightSubtree(Node<E> node) {
        E smallestKey = node.key;

        while (node != null) {
            smallestKey = node.key;

            node = node.left;
        }

        return smallestKey;
    }

    private int checkBalanceFactor(Node<E> node) {
        if (node == null) {
            return 0;
        }

        int balanceFactor = getHeight(node.left) - getHeight(node.right);

        return balanceFactor;
    }

    /**
     * 先序遍历 preorder traversal
     */
    public void preorderTraversal() {
        if (this.root != null) {
            preorderTraversalNode(this.root, 0);
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
        if (this.root != null) {
            postorderTraversalNode(this.root, 0);
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
        if (this.root != null) {
            inorderTraversalNode(this.root, 0);
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
        MyAVLTree<Integer> avlTree = new MyAVLTree<>();

        avlTree.insert(16);
        avlTree.insert(3);
        avlTree.insert(7);
        avlTree.insert(11);
        avlTree.insert(9);
        avlTree.insert(26);
        avlTree.insert(18);
        avlTree.insert(14);
        avlTree.insert(15);
        avlTree.insert(30);
        avlTree.insert(27);

        avlTree.preorderTraversal();

        /*
                       11
                   /       \
                 7          18
               /   \      /    \
              3     9   15      27
                       /  \     /  \
                      14  16   26  30
         */

        avlTree.delete(18);

        avlTree.preorderTraversal();

        /*
                      11
                   /       \
                 7          26
               /   \      /    \
              3     9   15      27
                       /  \       \
                      14  16       30

         */

    }


}
