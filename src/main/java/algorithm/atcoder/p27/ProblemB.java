package algorithm.atcoder.p27;

import java.util.Scanner;
import static java.util.Arrays.*;

public class ProblemB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] people = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            people[i] = sc.nextInt();
            sum += people[i];
        }

        int avergate = sum / len;
        int tmpsum = 0;
        int split = 0;
        int idx = 0;

        for (int i = 0; i <= len; i++) {
            if (i < len) {
                tmpsum += people[i];
            }
            if (tmpsum > 0 && tmpsum == idx*avergate) {
                tmpsum = 0;
                split++;
                idx = 0;
            }
            idx++;
        }

        if (sum % len != 0) {
            System.out.println(-1);
        } else if (split > 0) {
            System.out.println(len-split);
        } else {
            if (avergate == 0) System.out.println(0);
            else System.out.println(-1);
        }
    }
    public static void debug(Object...os) {
        System.out.println(deepToString(os));
    }
}

