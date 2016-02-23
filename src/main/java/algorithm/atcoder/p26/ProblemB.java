package algorithm.atcoder.p26;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] circles = new int[N];
        for (int i = 0; i < N; i++) {
            circles[i] = sc.nextInt();
        }
        Arrays.sort(circles);

        double sum = 0;
        boolean plus = true;
        for (int i = N-1; i >= 0; i--) {
            if (plus) {
                sum += circles[i] * circles[i];
            } else {
                sum -= circles[i] * circles[i];
            }
            plus = !plus;
        }

        System.out.println(sum * Math.PI);
    }
}
