package algorithm.atcoder.p25;

import java.util.Arrays;
import java.util.Scanner;
import static java.util.Arrays.*;

public class ProblemB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), A = sc.nextInt(), B = sc.nextInt();
        int ret = 0;
        while (N --> 0) {
            String direction = sc.next();
            int distance = sc.nextInt();
            distance = (distance >= A && distance <= B) ? distance : (distance < A ? A : B);
            if (direction.equals("East")) {
                ret += distance;
            } else {
                ret -= distance;
            }
        }
        if (ret == 0) System.out.println(0);
        else if (ret > 0) System.out.println("East " + Math.abs(ret));
        else if (ret < 0) System.out.println("West " + Math.abs(ret));
    }

    public static void debug(Object...os) {
        System.out.println(deepToString(os));
    }
}
