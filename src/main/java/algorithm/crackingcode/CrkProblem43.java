package algorithm.crackingcode;

//Given a sorted (increasing order) array,
//write an algorithm to create a binary tree with minimal height.

//learn: this problem lead to beautiful recursive

public class CrkProblem43 {

    static class TreeNode {
        TreeNode left = null;
        TreeNode right = null;
        int data;

        public TreeNode(int dat) { data = dat; }

        public static TreeNode addNode(int[] arr, int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = (start + end)/2;
            TreeNode node = new TreeNode(arr[mid]);
            node.left = addNode(arr, start, mid-1);
            node.right = addNode(arr, mid+1, end);
            return node;
        }

        public static int analyzeMinDepth(TreeNode node, int depth) {
            if (node.left == null && node.right == null) { //leaf
                return depth;
            } else {
                int l = -1;
                int r = -1;

                if (node.left != null) {
                    l = analyzeMinDepth(node.left, depth + 1);
                }
                if (node.right != null) {
                    r = analyzeMinDepth(node.right, depth + 1);
                }
                return ( l > r ? l : r);
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
        TreeNode root = TreeNode.addNode(arr, 0, 9);
        int d = TreeNode.analyzeMinDepth(root, 0);
        System.out.println(d);
    }

}
