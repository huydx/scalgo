package algorithm.atcoder.p29;

import java.util.Scanner;
import static java.util.Arrays.*;

public class ProblemB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 12, count = 0;
        while (n > 0)  {
            String str = sc.next();
            if (str.contains("r")) count++;
            --n;
        }
        System.out.println(count);
    }

    public static void debug(Object...os) {
        System.out.println(deepToString(os));
    }
}
