package algorithm.atcoder.p30;

import java.util.ArrayDeque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Problem3 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input;
            String[] data;
            input = br.readLine();
            int n,m;
            data = input.split(" ");
            n = Integer.parseInt(data[0]);
            m = Integer.parseInt(data[1]);

            input = br.readLine();
            int x,y;
            data = input.split(" ");
            x = Integer.parseInt(data[0]);
            y = Integer.parseInt(data[1]);

            input = br.readLine();
            String[] _timeA = input.split(" ");
            input = br.readLine();
            String[] _timeB = input.split(" ");

            int[] timeA = new int[_timeA.length];
            int[] timeB = new int[_timeB.length];
            for (int i = 0; i < timeA.length; i++) {
                timeA[i] = Integer.parseInt(_timeA[i]);
            }
            for (int j = 0; j < timeB.length; j++) {
                timeB[j] = Integer.parseInt(_timeB[j]);
            }

            int max = 0;
            boolean atA = true;

            Queue<Integer> queueA = new ArrayDeque<Integer>();
            Queue<Integer> queueB = new ArrayDeque<Integer>();
            for (int i = 0; i < timeA.length; i++) {
                queueA.add(timeA[i]);
            }
            for (int i = 0; i < timeB.length; i++) {
                queueB.add(timeB[i]);
            }

            while (true) {
                if (atA) {

                    atA = !atA;
                } else {
                    atA = !atA;
                }
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
