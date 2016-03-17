package algorithm.atcoder.languagetes;

import java.util.*;

public class ProblemB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] counter = new int[5];
        counter[0] = Integer.MAX_VALUE;
        sc.nextInt();
        String arr = sc.next();
        for (char c: arr.toCharArray()) {
            counter[c-48]++;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=1; i<=4; i++) {
            min = min < counter[i] ? min : counter[i];
            max = max > counter[i] ? max : counter[i];
        }

        System.out.println(max + " " + min);
    }
}
