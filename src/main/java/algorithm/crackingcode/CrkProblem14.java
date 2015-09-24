package algorithm.crackingcode;

import java.util.Arrays;

/**
 * in this problem using hashMap to count will lead to un-neccessary boxing, casting
 */
public class CrkProblem14 {
    private static boolean checkAnagram(char[] str1, char[] str2) {
        Arrays.sort(str1);
        Arrays.sort(str2);
        return ((new String(str1)).equals(new String(str2)));
    }

    private static boolean checkAnagramEff(char[] str1, char[] str2) {
        if (str1.length != str2.length) return false;
        int[] count1 = new int[1000];
        int[] count2 = new int[1000];

        int i;
        for (i = 0; i < 1000; i++) {
            count1[i] = 0;
            count2[i] = 0;
        }

        for (i = 0; i < str1.length; i++) {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }

        for (i = 0; i < str1.length; i++) {
            if (count1[str1[i]] != count2[str1[i]]) {
                return false;
            }
        }
        return true;
    }



    private static void println(Object obj) { System.out.println(obj); }

    public static void main(String[] args) {
        println(checkAnagramEff("foo".toCharArray(), "oof".toCharArray()));
        println(checkAnagramEff("foo".toCharArray(), "of".toCharArray()));
        println(checkAnagramEff("foo".toCharArray(), "offf".toCharArray()));
    }
}
