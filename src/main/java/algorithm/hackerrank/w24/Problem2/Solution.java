package algorithm.hackerrank.w24.Problem2;

import java.util.*;
import static java.util.Arrays.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();

        for(int a0 = 0; a0 < Q; a0++){
            int[] count = new int[100];
            int n = in.nextInt();
            if (n == 0) {
                System.out.println("YES");
                continue;
            }

            boolean satisfy = true;
            boolean hasSpace = false;
            String b = in.next();
            char[] bs = b.toCharArray();
            char current = bs[0];
            int currentCount = 1;

            for (int i = 0; i < bs.length; i++) {
                char b1 = bs[i];
                if (b1 == '_') {
                    hasSpace = true;
                    continue;
                }
                if (i > 0) {
                    if (b1 == current) {
                        currentCount++;
                    } else {
                        if (currentCount < 3) {
                            satisfy = false;
                        }
                        currentCount = 1;
                    }
                }
                current = b1;
                count[b1]++;
            }

            boolean hasOnlyOneChar = false;
            for (int aCount : count) {
                if (aCount == 1) {
                    hasOnlyOneChar = true;
                    break;
                }
            }

            if (satisfy) {
                System.out.println("YES");
            } else if (hasOnlyOneChar || !hasSpace) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    public static void debug(Object...os) {
        System.out.println(deepToString(os));
    }
}
