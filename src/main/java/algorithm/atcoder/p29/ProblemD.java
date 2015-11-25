package algorithm.atcoder.p29;

import java.util.Scanner;
import static java.util.Arrays.*;

public class ProblemD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = String.valueOf(n).length();
        int sum = 0;
        for (int i = 1; i <= len; i++) {
            sum += countOne(i, n);
        }
        System.out.println(sum);
    }

    public static int countOne(int index, int val) {
        int div = (int)Math.pow(10, index);
        int cnt = val / div;
        int q = val % div;
        int divv = (int)Math.pow(10, index-1);
        if (q < divv) return 0;
        if (q < 2*divv) return q+1-divv;
        return divv + cnt;
    }

    public static void debug(Object...os) {
        System.out.println(deepToString(os));
    }
}
