package algorithm.codeforce;
import java.util.Scanner;

import static java.util.Arrays.*;

public class Round330A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		int length = 2*m*n;
		int count = 0;
		int room = 0;

		while (sc.hasNext()) {
			int x1 = sc.nextInt();
			int x2 = sc.nextInt();
			if ((x1 + x2) >= 1) { room++; }
			count += 2;
			if (count == length) break;
		}
		System.out.println(room);
	}

	public static void debug(Object...os) {
		System.out.println(deepToString(os));
	}
}
