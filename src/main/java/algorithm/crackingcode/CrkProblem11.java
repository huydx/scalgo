package algorithm.crackingcode;

/*
Implement an algorithm to determine if a string has all unique characters.
What if you can not use additional data structures?
 */

import java.util.Arrays;

public class CrkProblem11 {
    private static boolean checkUnique(String input) {
        if (input.length() == 0 || input.length() == 1) {
            return true;
        }

        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        for (int i = 0; i < sorted.length() - 1; i++) {
            if (sorted.charAt(i) == sorted.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }

    private static void println(Object obj) {
        System.out.println(obj);
    }

    public static void main(String[] args) {
        println(checkUnique("a"));
        println(checkUnique(""));
        println(checkUnique("abc"));
        println(!checkUnique("aaxx"));
        println(!checkUnique("axwwwaa"));
        println(checkUnique("axbqt"));
    }
}
