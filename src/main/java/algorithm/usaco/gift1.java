package algorithm.usaco;

/*
ID: huydx
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

public class gift1 {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        Integer num = Integer.parseInt(f.readLine());
        HashMap<String, Integer> people = new HashMap<>();
        String[] peopleOrder = new String[num];
        for (int i = 0; i < num; i++) {
            String name = f.readLine();
            people.put(name, 0);
            peopleOrder[i] = name;
        }
        while (true) {
            String givePerson = f.readLine();
            if (givePerson == null) break;

            String money[] = f.readLine().split(" ");
            int amount = Integer.parseInt(money[0]);
            int toNum = Integer.parseInt(money[1]);

            int amountToEach = amount == 0 ? 0 : (amount - amount%toNum)/toNum;
            int amountLeft = amount == 0 ? 0 : amount%toNum;

            int current = people.get(givePerson);
            people.put(givePerson, current + amountLeft-amount);

            for (int i = 0; i < toNum; i++) {
                String toPerson = f.readLine();
                int p = people.get(toPerson);
                people.put(toPerson, p+amountToEach);
            }
        }

        for (int i = 0; i < num; i++) {
            out.println(peopleOrder[i] + " " + people.get(peopleOrder[i]));
        }
        out.close();
    }
}
