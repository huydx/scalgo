package algorithm.atcoder.p26;

import java.util.*;
import static java.util.Arrays.*;

public class ProblemC {
    static class Person {
        public List<Integer> lowers = new ArrayList<>();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Person[] persons = new Person[num+1];
        int count = 2;
        while (count < num+1) {
            int boss = sc.nextInt();
            if (persons[boss] == null) {
                persons[boss] = new Person();
            }
            persons[boss].lowers.add(count);
            count++;
        }
        System.out.println(traverse(1, persons));
    }

    public static int traverse(int index, Person[] all) {
        List<Integer> lowerSalary = new ArrayList<>();
        if (all[index] == null) {
            return 1;
        }
        for (int lower : all[index].lowers) {
            lowerSalary.add(traverse(lower, all));
        }
        int min = Collections.min(lowerSalary);
        int max = Collections.max(lowerSalary);
        return min + max + 1;
    }

    public static void debug(Object...os) {
        System.out.println(deepToString(os));
    }
}
