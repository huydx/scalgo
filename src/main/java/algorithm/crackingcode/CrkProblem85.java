package algorithm.crackingcode;

//Implement an algorithm to print all valid
// (e.g., properly opened and closed) combi- nations of n-pairs of parentheses.
//EXAMPLE:
//       input: 3 (e.g., 3 pairs of parentheses) output: ()()(), ()(()), (())(), ((()))

public class CrkProblem85 {
    public static void printPar(int count) {
        char[] str = new char[count*2];
        printPar(count, count, str, 0);
    }

    public static void printPar(int lcount, int rcount, char[] str, int count) {
        if (lcount == 0 && rcount == 0) {
            System.out.println(str);
        } else {
            if (lcount > 0) {
                str[count] = '(';
                printPar(lcount-1, rcount, str, count+1);
            }
            if (rcount > lcount) { //learn this check is smart
                str[count] = ')';
                printPar(lcount, rcount-1, str, count+1);
            }
        }
    }

    public static void main(String[] args) {
        printPar(3);
    }
}
