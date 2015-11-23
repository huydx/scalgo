package algorithm.other;

public class Multiplication {
	public static boolean odd(int n) {
		return (n & 1) == 1;
	}

	public static int half(int n) {
		return n >> 1;
	}

	public static int multiply(int r, int n, int a) {
		int count = 0;
		while(true) {
			count ++;
			if (odd(n)) {
				r = r + a;
				if (n == 1) {
					System.out.println(count);
					return r;
				}
			}
			n = half(n);
			a = a + a;
		}
	}

	public static int slowMultiply(int r, int n, int a) {
		int count = 0;
		for (int i=0; i<n; i++) {
			count++;
			r = r + a;
		}
		System.out.println(count);
		return r;
	}

	public static void main(String[] args) {
		System.out.println(multiply(1,100,3));
		System.out.println(slowMultiply(1, 100, 3));
	}
}
