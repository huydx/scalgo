package algorithm.atcoder.p24;

import java.util.*;

public class ProblemA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int K = sc.nextInt();
        int S = sc.nextInt();
        int T = sc.nextInt();

        if (S+T >= K) {
            A = A - C; B = B - C;
        }

        System.out.println(A*S+B*T);
    }
}