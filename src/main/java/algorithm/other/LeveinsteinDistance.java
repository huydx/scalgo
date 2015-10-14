package algorithm.other;

public class LeveinsteinDistance {
    public static int editDistance(char[] word1, char[] word2) {
        int len1 = word1.length;
        int len2 = word2.length;

        int[][] matrix = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; ++i) matrix[i][0] = i;
        for (int j = 0; j <= len2; ++j) matrix[0][j] = j;

        matrix[0][0] = word1[0] == word2[0] ? 0 : 1;

        for (int i = 1; i < len1; ++i) {
            for (int j = 1; j < len2; ++j) {
                if (word1[i] == word2[j]) {
                    matrix[i][j] = matrix[i-1][j-1];
                    //System.out.println("update matrix "+i+", "+j+" : "+ matrix[i][j]);
                } else {
                    int min = Math.min(matrix[i-1][j], matrix[i][j-1]);
                    min = Math.min(min, matrix[i-1][j-1]);
                    matrix[i][j] = min + 1;
                    //System.out.println("update matrix "+i+", "+j+" : "+ matrix[i][j]);
                }
            }
        }
        return matrix[len1-1][len2-1];
    }


    public static void main(String[] args) {
        String word1 = "foeo";
        String word2 = "feee";
        System.out.println(editDistance(word1.toCharArray(), word2.toCharArray()));
    }
}
