package algorithm.atcoder.p27;

import java.util.Scanner;
import static java.util.Arrays.*;

public class ProblemA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int x = sc.nextInt();
        final int y = sc.nextInt();
        final int z = sc.nextInt();
        System.out.println(x ^ y ^ z);
    }
}
