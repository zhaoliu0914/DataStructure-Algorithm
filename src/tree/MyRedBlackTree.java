package tree;

import java.math.BigDecimal;

/**
 * 在 Red-Black Tree 中新插入的节点默认是红色的
 * There are 3 cases during insertion:
 * Case 1 :
 * # 新插入的节点的父节点是黑色的，这种情况不会违反 Red-Black Tree 的定义
 * # 所以不需要调整，插入完成
 * # 例如：新插入 节点 11
 * #        7(Black)
 * #      /       \
 * #  3(Black)    16(Black)
 * #              /
 * #            11(Red)
 * <p>
 * Case 2 :
 * # 新插入的节点的父节点是红色，并且新插入节点的 Uncle节点 也是红色的
 * # 这种情况只需要重新染色，不需要左旋和右旋
 * # 例如：新插入 节点 26
 * #        11(Black)                                   11(Red)
 * #       /      \                                    /      \
 * #    9(Red)    16(Red)           染色成：        9(Black)    16(Black)
 * #                \                                           \
 * #                26(Red)                                     26(Red)
 * <p>
 * Case 3 :
 * # 新插入的节点的父节点是红色，并且新插入的节点的 Uncle节点 是黑色或者是个 Null节点
 * # 这种情况就需要旋转和重新染色
 * # 而且旋转的情况也有4种，分别是AVL Tree 对应的 Left-Left, Right-Right, Left-Right, Right-Left
 * # <b>对于4种旋转所对应的染色，都是将旋转过后的根节点染成黑色的，左右2个节点都染成红色的</b>
 * # 例子：
 * #    1). Left-Left 旋转和染色，例如：新插入 节点 9
 * #             16(Black)                                          11(Black)
 * #            /                                                  /     \
 * #          11(Red)                 旋转并染色成：              9(Red)    16(Red)
 * #         /     \                                                     /
 * #       9(Red)   12(Black)                                          12(Black)
 * #
 * #    2). Right-Right 旋转加染色，例如：新插入 节点 16
 * #         7(Black)                                                11(Black)
 * #          \                                                     /     \
 * #          11(Red)                 旋转并染色成：                7(Red)   16(Red)
 * #         /     \                                               \
 * #     10(Black) 16(Red)                                        10(Black)
 * #
 * #    3). Left-Right 旋转加染色，例如： 新插入 节点 14
 * #              16(Black)                                          14(Black)
 * #             /                                                  /     \
 * #           11(Red)                旋转并染色为：               11(Red)  16(Red)
 * #             \
 * #             14(Red)
 * #
 * #    4). Right-Left 旋转加染色，例如： 新插入 节点 18
 * #            16(Black)                                           18(Black)
 * #               \                                                /      \
 * #                26(Red)           旋转并染色为：                16(Red)  26(Red)
 * #               /
 * #              18(Red)
 * #
 * # 总结：重新染色的情况包括 2种。一种是 Uncle节点是红色的情况，一种是 Uncle节点是黑色的情况。
 * #      只染色的情况的逻辑是：grandparent节点变成 红色，父节点和Uncle节点都变成 黑色。
 * #      旋转加染色的逻辑是：  旋转过后的子树的根节点变成 黑色，子树的左节点和右节点变成 红色。
 * <p>
 * Insertion Algorithm:
 * Let x be the newly inserted node.
 * 1. Perform standard BST insertion and make the colour of newly inserted nodes as RED.
 * 2. If x is the root, change the colour of x as BLACK (Black height of complete tree increases by 1).
 * 3. Do the following if the color of x’s parent is not BLACK and x is not the root.
 * #   a) If x’s uncle is RED (Grandparent must have been black from property 4)
 * #     (i) Change the colour of parent and uncle as BLACK.
 * #     (ii) Colour of a grandparent as RED.
 * #     (iii) Change x = x’s grandparent, repeat steps 2 and 3 for new x.
 * #   b) If x’s uncle is BLACK, then there can be four configurations for x, x’s parent (p) and x’s grandparent (g) (This is similar to AVL Tree)
 * #     (i) Left Left Case (p is left child of g and x is left child of p)
 * #     (ii) Left Right Case (p is left child of g and x is the right child of p)
 * #     (iii) Right Right Case (Mirror of case i)
 * #     (iv) Right Left Case (Mirror of case ii)
 *
 * @param <K>
 * @param <V>
 */
public class MyRedBlackTree<K, V> {

    private enum Color {
        RED, BLACK
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Color color;
        private Node<K, V> parent;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V value, Color color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    private Node<K, V> root;

    private boolean performLeftRotation = false;
    private boolean performRightRotation = false;
    private boolean performLeftRightRotation = false;
    private boolean performRightLeftRotation = false;

    public boolean insertWithRecursion(K key, V value) {
        if (key == null) {
            System.out.println("Can not insert Null.");
            return false;
        }

        if (this.root == null) {
            Node<K, V> node = new Node<>(key, value, Color.BLACK);
            this.root = node;
        } else {
            this.root = insertNodeWithRecursion(this.root, key, value);
        }

        return true;
    }

    /**
     * This method will insert new Node recursively.
     * The insert operation just performs standard BST insertion for new Node.
     * The new Node is always RED.
     * We have to check Red Conflict after insert a new Node.
     * Red Conflict means new Node is Red and his parent node is also red.
     * <p>
     * If its colour of parent is black then don’t change the colour
     * But if it is not , it is red then check the colour of the node’s uncle.
     * This is Red Conflict.
     * <p>
     * If the node’s uncle has a red colour then change the colour of the node’s parent and uncle to black and that of grandfather to red colour
     * and repeat the same process for him (i.e. grandfather).
     * But, if the node’s uncle has black colour then there are 4 possible cases:
     * Left-Left Case
     * Right-Right Case
     * Left-Right Case
     * Right-Left Case
     * <p>
     * If there are just simply re-color nodes without rotation,
     * grandparent node will change to Red, and parent and uncle will change to Black.
     * <p>
     * If there are rotation and re-color nodes,
     * the new root node of subtree will change to Black, and left node and right node of subtree will change to Red.
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node<K, V> insertNodeWithRecursion(Node<K, V> node, K key, V value) {
        boolean isRedConflict = false;

        // If the tree is empty, return a new node
        // Otherwise, recursive down the tree
        if (node == null) {
            return new Node<>(key, value, Color.RED);

        } else if (new BigDecimal(key.toString()).compareTo(new BigDecimal(node.key.toString())) < 0) {
            // If the key is smaller than node.key than looking for the left subtree
            // It will insert into left node when { new Node<>() } return
            node.left = insertNodeWithRecursion(node.left, key, value);

            // set parent node
            node.left.parent = node;

            // check Red Conflict.
            if (node != this.root) {
                if (node.color.equals(Color.RED) && node.left.color.equals(Color.RED)) {
                    isRedConflict = true;
                }
            }

        } else if (new BigDecimal(key.toString()).compareTo(new BigDecimal(node.key.toString())) > 0) {
            // If the key is greater than node.key than looking for the right subtree
            // It will insert into right node when { new Node<>() } return
            node.right = insertNodeWithRecursion(node.right, key, value);

            // set parent node
            node.right.parent = node;

            // check Red Conflict.
            if (node != this.root) {
                if (node.color.equals(Color.RED) && node.right.color.equals(Color.RED)) {
                    isRedConflict = true;
                }
            }

        } else {
            // duplicated key.
            // the new Value will replace the old Value.
            node.value = value;
            return node;
        }


        if (this.performLeftRotation) {
            // This is for single Left Rotation.

            this.performLeftRotation = false;

            // perform Left Rotation and then re-color the subtree nodes.
            // the new root node of subtree will change to Black, and left node and right node of subtree will change to Red.
            node = leftRotation(node);
            node.color = Color.BLACK;
            node.left.color = Color.RED;
            node.right.color = Color.RED;

        } else if (this.performRightRotation) {
            // This is for single Right Rotation.

            this.performRightRotation = false;

            // perform Right Rotation and then re-color the subtree nodes.
            // the new root node of subtree will change to Black, and left node and right node of subtree will change to Red.
            node = rightRotation(node);
            node.color = Color.BLACK;
            node.left.color = Color.RED;
            node.right.color = Color.RED;

        } else if (this.performLeftRightRotation) {
            // This is for Left Rotation and then Right Rotation.

            this.performLeftRightRotation = false;

            // perform Left-Right Rotation and then re-color the subtree nodes.
            // the new root node of subtree will change to Black, and left node and right node of subtree will change to Red.

            // perform Left Rotation.
            node.left = leftRotation(node.left);
            node.left.parent = node;

            // and then perform Right Rotation.
            node = rightRotation(node);
            node.color = Color.BLACK;
            node.left.color = Color.RED;
            node.right.color = Color.RED;

        } else if (this.performRightLeftRotation) {
            // This is for Right Rotation and then Left Rotation.

            this.performRightLeftRotation = false;

            // perform Right-Left Rotation and then re-color the subtree nodes.
            // the new root node of subtree will change to Black, and left node and right node of subtree will change to Red.

            // perform Right Rotation.
            node.right = rightRotation(node.right);
            node.right.parent = node;

            // and then perform Left Rotation.
            node = leftRotation(node);
            node.color = Color.BLACK;
            node.left.color = Color.RED;
            node.right.color = Color.RED;
        }

        if (isRedConflict) {
            Node<K, V> siblingNode;

            // Red Conflict happens on the right side.
            if (node == node.parent.right) {
                siblingNode = node.parent.left;

                // It matches Case 2. So it only needs to be re-color and do not need to rotation.
                if (siblingNode != null && Color.RED.equals(siblingNode.color)) {
                    node.color = Color.BLACK;
                    siblingNode.color = Color.BLACK;
                    if (node.parent != this.root) {
                        node.parent.color = Color.RED;
                    }

                } else {
                    // It matches Case 3.
                    // It needs to rotate and re-color.
                    // There are only 2 cases which are Right-Right case and Right-Left case happening on the right side.
                    // They need Single Left Rotation or Right Left Rotation.

                    // This is Right-Right Case.
                    if (node.right != null && Color.RED.equals(node.right.color)) {
                        this.performLeftRotation = true;

                    } else if (node.left != null && Color.RED.equals(node.left.color)) { // This is Right-Left Case.
                        this.performRightLeftRotation = true;

                    }
                }

            } else {
                // Red Conflict happens on the left side.
                siblingNode = node.parent.right;

                // It matches Case 2. So it only needs to be re-color and do not need to rotation.
                if (siblingNode != null && Color.RED.equals(siblingNode.color)) {
                    node.color = Color.BLACK;
                    siblingNode.color = Color.BLACK;
                    if (node.parent != this.root) {
                        node.parent.color = Color.RED;
                    }

                } else {
                    // It matches Case 3.
                    // It needs to rotate and re-color.
                    // There are only 2 cases which are Left-Left case and Left-Right case happening on the left side.
                    // They need Single Right Rotation or Left-Right Rotation.

                    // This is Left-Left Case.
                    if (node.left != null && Color.RED.equals(node.left.color)) {
                        this.performRightRotation = true;

                    } else if (node.right != null && Color.RED.equals(node.right.color)) {// This is Left-Right Case.
                        this.performLeftRightRotation = true;

                    }
                }
            }

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
     * 2. update parent : for example Node 11 becomes parent to Node 7, and Node 7 become parent to Node 9
     *
     * @param node this parameter is first node of subtree, for example: 7
     * @return
     */
    private Node<K, V> leftRotation(Node<K, V> node) {
        Node<K, V> middleNode = node.right;
        Node<K, V> middleLeftNode = middleNode.left;

        // step 1 : perform rotation
        middleNode.left = node;
        node.right = middleLeftNode;

        // step 2 : update parent
        node.parent = middleNode;
        if (middleLeftNode != null) {
            middleLeftNode.parent = node;
        }

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
     * 2. update heights : for example Node 11 become parent to Node 16, and Node 16 become parent to node 12
     *
     * @param node this parameter is first node of subtree, for example: 16
     * @return
     */
    private Node<K, V> rightRotation(Node<K, V> node) {
        Node<K, V> middleNode = node.left;
        Node<K, V> middleRightNode = middleNode.right;

        // step 1 : perform rotation
        middleNode.right = node;
        node.left = middleRightNode;

        // step 2 : update parent
        node.parent = middleNode;
        if (middleRightNode != null) {
            middleRightNode.parent = node;
        }

        return middleNode;
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
    private void preorderTraversalNode(Node<K, V> node, int indent) {
        if (node != null) {
            for (int i = 0; i < indent; i++) {
                System.out.print("\t");
            }
            System.out.println(node.key + "(" + node.color + ")");

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
    private void postorderTraversalNode(Node<K, V> node, int indent) {
        if (node != null) {
            postorderTraversalNode(node.left, indent + 1);
            postorderTraversalNode(node.right, indent + 1);

            for (int i = 0; i < indent; i++) {
                System.out.print("\t");
            }
            System.out.println(node.key + "(" + node.color + ")");
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
    private void inorderTraversalNode(Node<K, V> node, int indent) {
        if (node != null) {
            inorderTraversalNode(node.left, indent + 1);

            for (int i = 0; i < indent; i++) {
                System.out.print("\t");
            }
            System.out.println(node.key + "(" + node.color + ")");

            inorderTraversalNode(node.right, indent + 1);
        }
    }

    public static void main(String[] args) {
        MyRedBlackTree<Integer, String> redBlackTree = new MyRedBlackTree<>();

        redBlackTree.insertWithRecursion(16, "A");
        redBlackTree.insertWithRecursion(3, "B");
        redBlackTree.insertWithRecursion(7, "C");
        redBlackTree.insertWithRecursion(11, "D");
        redBlackTree.insertWithRecursion(9, "E");
        redBlackTree.insertWithRecursion(26, "F");
        redBlackTree.insertWithRecursion(18, "G");
        redBlackTree.insertWithRecursion(14, "H");

        redBlackTree.inorderTraversal();

    }


}
