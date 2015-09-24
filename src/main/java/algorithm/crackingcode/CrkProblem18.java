package algorithm.crackingcode;

//Assume you have a method isSubstring which checks if one word is a substring of another.
//Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
//(i.e., “waterbottle” is a rotation of “erbottlewat”).

public class CrkProblem18 {
    public static boolean checkRotate(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        String doubleStr1 = str1 + str1;
        return (doubleStr1.contains(str2));
    }

    public static void main(String[] args) {
        System.out.println(checkRotate("waterbottle", "erbottlewat"));
    }
}
