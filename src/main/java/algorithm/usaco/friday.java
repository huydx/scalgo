package algorithm.usaco;

import java.io.*;
import java.util.*;

public class friday {
    public int[] month30 =  new int[] { 9, 4, 6, 11 };
    public int[] month31 =  new int[] { 1, 3, 5, 7, 8, 10, 12 };
    public int monthleap =  2;


    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("test.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
        Integer N = Integer.parseInt(f.readLine());
        out.println();
        out.close();
    }

    /**
     * day : 0-monday, 1-tuesday....6-sunday
     */
    public static int[] next(int day, int month, int year, int prob[]) {
        return new int[] { day, month, year };
    }

    public boolean included(int[] list, int elem) {
        for (int e: list) { if (e == elem) return true; }
        return false;
    }

    public static void output(int N, int year, int[] prob, PrintWriter out) {
        if (year == 1900 + N) {
            String ret = "";
            for (int i = 0; i < 7; i++) {
                ret += prob[i];
                if (i < 6) ret += " ";
            }
            out.println(ret);
        }
    }
}
