package algorithm.other;

import java.util.Scanner;

public class BitDpTrain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i=0; i<(1<<N); i++) {
			String st = "";
			for (int j=0; j<N; j++) {
				if ((i>>j)%2==0) st += "o";
				else st += "x";
			}
			System.out.println(st);
		}
	}
}
