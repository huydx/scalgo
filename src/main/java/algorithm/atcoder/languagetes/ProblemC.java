package algorithm.atcoder.languagetes;

import java.util.*;

public class ProblemC {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int start1 = 1;
        int start2 = -1;
        int max = Integer.MIN_VALUE;
        for (int i = start1; i <= num; i++) {
            String query = "? " + start1 + " " + i;
            System.out.println(query);
            int ans = sc.nextInt();
            if (ans > max) {
                start2 = i;
                max = ans;
            }
        }

        max = Integer.MIN_VALUE;
        for (int i = start2; i <= num; i++) {
            if (i == start1) continue;
            String query = "? " + start2 + " " + i;
            System.out.println(query);
            int ans = sc.nextInt();
            if (ans > max) {
                max = ans;
            }
        }

        System.out.println("! " + max);
    }
}
