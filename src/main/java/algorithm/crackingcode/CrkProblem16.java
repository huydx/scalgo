package algorithm.crackingcode;

public class CrkProblem16 {
    public static void rotateMatrix(int[][] matrix, int n) {
        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[last][first];
                matrix[i][last] = top;
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        rotateMatrix(input, 3);
        System.out.print(input[0][0]);
    }
}
