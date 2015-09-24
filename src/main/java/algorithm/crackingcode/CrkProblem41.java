package algorithm.crackingcode;

//Implement a function to check if a tree is balanced.
//For the purposes of this question, a balanced tree is defined
//to be a tree such that no two leaf nodes differ in distance from the root by more than one.

//idea is that: find maxDepth by recursive, find minDepth by recursive
// -> maxDepth - minDepth

import algorithm.datastructure.BinaryTree;

public class CrkProblem41 {
    public static void main(String[] args) { //learn: void sit at last..
        BinaryTree tree = new BinaryTree(0);
        tree.insert(1);
        tree.insert(3);
        tree.insert(4);
        tree.insert(4);
        tree.insert(4);
        tree.insert(4);
        tree.insert(4);

        System.out.println(tree.isBalance());
    }
}
