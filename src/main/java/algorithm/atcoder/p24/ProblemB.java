package algorithm.atcoder.p24;

import java.util.*;

public class ProblemB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int[] start = new int[N];
        for (int i = 0; i < N; i++) {
            start[i] = sc.nextInt();
        }

        long sum = T;
        for (int i = 1; i < N; i++) {
            int gap = start[i-1] + T > start[i] ? start[i] - start[i-1] : T;
            sum += gap;
        }

        System.out.println(sum);
    }
}
