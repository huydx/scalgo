package algorithm.geeks4geeks;

//convert a number m to n with minimum operations. The operations allowed were -1 and *2.

import java.util.Scanner;

public class G4GProblem2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(), n = sc.nextInt();
		int step = 0;
		while (m != n) {
			if (m > n) {
				m--;step++;
			} else {
				if (n % 2 == 0) { n=n/2;step++; }
				else if (n % 2 == 1) { n=(n+1)/2;step+=2; }
			}
		}
		System.out.println(step);
	}

	public static void println(Object obj) {
		System.out.println(obj);
	}
}
