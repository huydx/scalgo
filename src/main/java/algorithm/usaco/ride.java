package algorithm.usaco;

/*
ID: huydx
LANG: JAVA
TASK: ride
*/
import java.io.*;

public class ride {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String comet = f.readLine();
        String group = f.readLine();
        int sumcomet = 1;
        for (char c : comet.toCharArray()) {
            sumcomet *= (c - 'A' + 1);
            sumcomet = sumcomet%47;
        }
        int sumgroup = 1;
        for (char c : group.toCharArray()) {
            sumgroup *= (c - 'A' + 1);
            sumgroup = sumgroup%47;
        }
        boolean go = sumcomet % 47 == sumgroup % 47;
        String ret = go ? "GO" : "STAY";
        out.println(ret);                             // output result
        out.close();                                  // close the output file
    }
}
