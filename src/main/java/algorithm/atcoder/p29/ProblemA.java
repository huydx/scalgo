package algorithm.atcoder.p29;

import java.util.Scanner;
import static java.util.Arrays.*;

public class ProblemA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder text = new StringBuilder(sc.next());
        text.append('s');
        System.out.println(text.toString());
    }

    public static void debug(Object...os) {
        System.out.println(deepToString(os));
    }
}
