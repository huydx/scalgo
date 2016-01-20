package algorithm.atcoder.p25;

import java.util.Arrays;
import java.util.Scanner;
import static java.util.Arrays.*;

public class ProblemD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] mtx = new int[5][5];
        boolean[] all = new boolean[26];
        int i = 0, j = 0;
        while (j<5) {
            if (i==5) { j++;i=0; }
            if (j==5) break;
            mtx[i][j] = sc.nextInt();
            all[mtx[i][j]] = true;
            i++;
        }

    }

    public static void debug(Object...os) {
        System.out.println(deepToString(os));
    }
}
