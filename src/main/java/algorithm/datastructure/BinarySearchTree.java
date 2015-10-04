package algorithm.datastructure;

//implementation of binary tree (not binary search tree with order)
//implementation of tree almostly need recursive like insert, count, inorder, preorder, postorder...

import java.util.*;

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

    public BinarySearchTreeNode insert(BinarySearchTreeNode node, int _data) {
        if (node == null) {
            node = new BinarySearchTreeNode(_data);
        } else {
            if (node.data < _data) {
                node.right = insert(node.right, _data);
            } else {
                node.left = insert(node.left, _data);
            }
        }
        return node;
    }

    public ArrayList<LinkedList<BinarySearchTreeNode>> createLevelLinkedList(BinarySearchTreeNode node) {
        int level = 0;
        ArrayList<LinkedList<BinarySearchTreeNode>> result = new ArrayList<LinkedList<BinarySearchTreeNode>>();
        LinkedList<BinarySearchTreeNode> list = new LinkedList<BinarySearchTreeNode>();
        list.add(root);
        result.add(level, list);
        while (true) {
            list = new LinkedList<BinarySearchTreeNode>();
            for (int i = 0; i < result.get(level).size(); i++) {
                BinarySearchTreeNode n = (BinarySearchTreeNode) result.get(level).get(i);
                if (n != null) {
                    if (n.left != null) list.add(n.left);
                    if (n.right != null) list.add(n.right);
                }
            }
            if (list.size() > 0) {
                result.add(level+1, list);
            } else {
                break;
            }
            level++;
        }
        return result;
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
