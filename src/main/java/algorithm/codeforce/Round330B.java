package algorithm.codeforce;

import java.util.Scanner;

import static java.util.Arrays.*;

public class Round330B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		int len = n/k;
		int limit = (int)Math.pow(10,9);
		int[] a = new int[len];
		int[] b = new int[len];
		for (int i=0; i<len; i++) {
			a[i] = sc.nextInt();
		}
		for (int i=0; i<len; i++) {
			b[i] = sc.nextInt();
		}

		double ret = 1;
		for (int i=0; i<len; i++) {
			int max = (int)Math.pow(10,k);
			int bmax = max/10;
			int count = max/a[i]+1; //+1 for 00
			if (max % a[i] == 0) count--;
			if (a[i] < bmax) {
				count -= (bmax-1)/a[i];
			} else {
				int f = b[i] / (a[i] / bmax);
				if ((a[i] * f)/bmax == b[i]) count--;
			}
			debug(count);
			ret *= count;
			ret = ret % limit;
		}
		System.out.println((int)ret);
	}

	public static void debug(Object...os) {
		System.out.println(deepToString(os));
	}
}
