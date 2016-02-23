package algorithm.atcoder.p26;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        if (A % 2 == 0) System.out.println((A/2)*(A/2));
        if (A % 2 == 1) System.out.println((A/2)*(A/2 + 1));
    }
}
