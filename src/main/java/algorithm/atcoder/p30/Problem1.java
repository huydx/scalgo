package algorithm.atcoder.p30;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem1 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input;
            input = br.readLine();
            assert input != null;
            String[] infos = input.split(" ");
            double takahashi = Double.parseDouble(infos[1]) / Double.parseDouble(infos[0]);
            double aoki = Double.parseDouble(infos[3]) / Double.parseDouble(infos[2]);
            if (aoki > takahashi) {
                System.out.println("AOKI");
            } else if (aoki < takahashi) {
                System.out.println("TAKAHASHI");
            } else {
                System.out.println("DRAW");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
