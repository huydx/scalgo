package algorithm.crackingcode;

//Write an algorithm such that if an element in an MxN matrix is 0,
//its entire row and column is set to 0.

public class CrkProblem17 {
    public static void setMatrix(int[][] input, int row, int col) {
        int[] zeroRow = new int[row];
        int[] zeroCol = new int[col];

        for (int i = 0; i < row; i++){
            for (int j = 0; i < row; i++){
                if (input[i][j] == 0) {
                    zeroRow[i] = 0;
                    zeroCol[j] = 0;
                }
            }
        }

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (zeroRow[i] == 0 || zeroCol[j] == 0) {
                    input[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
                {1,2,0},
                {2,0,3},
                {4,5,6}
        };

        setMatrix(input, 3, 3);
        System.out.print(input[1][2]);
    }
}
