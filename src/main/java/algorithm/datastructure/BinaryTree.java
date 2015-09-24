package algorithm.datastructure;

//implementation of binary tree (not binary search tree with order)
//implementation of tree almostly need recursive like insert, count, inorder, preorder, postorder...


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BinaryTree {

    public static class BinaryTreeNode {
        public BinaryTreeNode left = null;
        public BinaryTreeNode right = null;
        public int data = -1;

        public BinaryTreeNode(int dat) {
            data = dat;
        }
    }

    private BinaryTreeNode root;

    public BinaryTree(int dat) {
        root = new BinaryTreeNode(dat);
    }

    public void insert(int dat) {
        insert(root, dat);
    }

    public BinaryTreeNode insert(BinaryTreeNode node, int data) {
        if (node == null) {
            node = new BinaryTreeNode(data);
        } else {
            if (node.right == null) {
                node.right = insert(node.right, data);
            } else {
                node.left = insert(node.left, data);
            }
        }
        return node;
    }


    private ArrayList<Integer> depthCount = new ArrayList<Integer>();
    private void traverseWithDepthCount(BinaryTreeNode currentNode, int depth) {
        if (currentNode.left == null && currentNode.right == null) {
            System.out.println("increase depthcount: " + depth);
            depthCount.add(depth);
        } else {
            if (currentNode.left != null) traverseWithDepthCount(currentNode.left, depth+1);
            if (currentNode.right != null) traverseWithDepthCount(currentNode.right, depth+1);
        }
    }

    private boolean isBalance(BinaryTreeNode root) {
        traverseWithDepthCount(root, 0);
        int min = Collections.min(depthCount); //learn: use Collections.min and max to find min max of a collection
        int max = Collections.max(depthCount);

        return (max - min <= 1);
    }

    public boolean isBalance() {
        return isBalance(root);
    }

    public void inorder(BinaryTreeNode node) {
        if (node != null) {
            inorder(node.left);
            action(node);
            inorder(node.right);
        }
    }

    public void preorder(BinaryTreeNode node) {
        if (node != null) {
            action(node);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(BinaryTreeNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            action(node);
        }
    }

    public void action(BinaryTreeNode node) {
        System.out.println(node.data);
    }
}
