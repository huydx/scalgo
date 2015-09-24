package algorithm.crackingcode;

public class CrkProblem13 {
    private static void removeDuplicateChar(char[] chars) {
        if (chars == null) return;
        int len = chars.length;
        if (len < 2) return;

        int tail = 1;
        for (int i = 1; i < len; ++i) {
            int j;
            for (j = 0; j < tail; ++j) {
                if (chars[i] == chars[j]) break;
            }
            if (j == tail) {
                chars[tail] = chars[i];
                ++tail;
            }
        }
        chars[tail] = 0;
    }

    public static void main(String[] args) {
        char[] input = "abcd".toCharArray();
        removeDuplicateChar(input);
    }
}
