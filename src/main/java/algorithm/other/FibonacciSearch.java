package algorithm.other;

public class FibonacciSearch {
    public static int search(int[] array, int val) {
        //Let Fk represent the k-th Fibonacci number where Fk+2=Fk+1 + Fk for k>=0 and F0 = 0, F1 = 1.
        int[] Fib = new int[] {
            0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765,
            10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578,
            5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296,
            433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE
        };
        int last = array.length-1;
        int m = 0;

        // To test whether an item is in a list of n = Fm ordered numbers
        for (int i=0; i<Fib.length; i++) {
            if (last <= Fib[i]) {
                m = i;
                break;
            }
        }
        int offset = 0;
        int k = m;
        if (k == 0) {
            return -1;
        }
        for (offset = 0;k > 0;) {
            int idx = offset + Fib[--k];
            System.out.println("idx: "+idx + ", k: " + k + ", offset: "+ offset);
            if (idx >= array.length || val < array[idx]) continue;
            else if (val > array[idx]) {
                offset = idx;
                --k;
            } else {
                return idx;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,4,5,6,7,8,9,10,11,12,13};
        int val = 4;
        System.out.println(search(arr, val));
    }
}
