package algorithm.atcoder.p25;

import java.util.Arrays;
import java.util.Scanner;
import static java.util.Arrays.*;

public class ProblemA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] S = sc.next().toCharArray();
        int N = sc.nextInt();
        Arrays.sort(S);
        int size = S.length;

        //最初からインデックス正規化したら便利
        int firstidx = N%size == 0 ? N/size-1 : N/size;
        int secidx = N%size == 0 ? size-1 : N%size-1;

        char first = S[firstidx];
        char sec = S[secidx];
        System.out.println(new StringBuilder().append(first).append(sec));
    }

    public static void debug(Object...os) {
        System.out.println(deepToString(os));
    }
}
