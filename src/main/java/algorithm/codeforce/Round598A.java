package algorithm.codeforce;

import java.util.Scanner;

public class Round598A {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long t = scan.nextLong();
		for(int i=0; i<t; i++)
		{
			long n = scan.nextLong();
			long s = n*(n+1)/2;
			long m = 1;
			while(m <=n)
			{
				s-=2*m;
				m*=2;
			}
			System.out.println(s);
		}
	}
}
