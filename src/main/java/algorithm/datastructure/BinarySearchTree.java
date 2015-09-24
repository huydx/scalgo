package algorithm.datastructure;

//implementation of binary tree (not binary search tree with order)
//implementation of tree almostly need recursive like insert, count, inorder, preorder, postorder...


public class BinarySearchTree {

    static class BinarySearchTreeNode {
        public BinarySearchTreeNode left = null;
        public BinarySearchTreeNode right = null;
        public int data = -1;

        public BinarySearchTreeNode(int dat) {
            data = dat;
        }
    }

    private BinarySearchTreeNode root;

    public BinarySearchTreeNode insert(BinarySearchTreeNode node, int data) {
        if (node == null) {
            node = new BinarySearchTreeNode(data);
        } else {
            if (node.right == null) {
                node.right = insert(node.right, data);
            } else {
                node.left = insert(node.left, data);
            }
        }
        return node;
    }

    public void inorder(BinarySearchTreeNode node) {
        if (node != null) {
            inorder(node.left);
            action(node);
            inorder(node.right);
        }
    }

    public void preorder(BinarySearchTreeNode node) {
        if (node != null) {
            action(node);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(BinarySearchTreeNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            action(node);
        }
    }

    public void action(BinarySearchTreeNode node) {
        System.out.println(node.data);
    }
}
