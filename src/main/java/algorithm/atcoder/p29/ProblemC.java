package algorithm.atcoder.p29;
import java.util.Scanner;
import static java.util.Arrays.*;

public class ProblemC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        permute(0, n, "");
    }

    public static void permute(int index, int max, String prefix) {
        if (index == max) {
            System.out.println(prefix);
        }
        else {
            permute(index+1, max, prefix+"a");
            permute(index+1, max, prefix+"b");
            permute(index+1, max, prefix+"c");
        }
    }

    public static void debug(Object...os) {
        System.out.println(deepToString(os));
    }
}
