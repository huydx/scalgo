package algorithm.atcoder.p30;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input;
            input = br.readLine();
            assert input != null;
            String[] datas = input.split(" ");
            double x = Double.parseDouble(datas[0]);
            double y = Double.parseDouble(datas[1]);

            if (x==12) x=0;
            if (y==60) y=0;

            double hangle = (x/12)*360;
            double mangle = (y/60)*360;
            double res = Math.abs(hangle-mangle);
            System.out.println(Math.min(res, Math.abs(res-360)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
