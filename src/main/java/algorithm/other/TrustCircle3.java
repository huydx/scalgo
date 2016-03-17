package algorithm.other;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TrustCircle3 {
    public static void main(String[] args) {

    }

    static BitSet sketch(String in) {
        BitSet sketch = new BitSet();
        for (char c: in.toCharArray()) {
           sketch.set(c);
        }
        return sketch;
    }

    static int[] sibling(String[] inputs, String[] queries) {
        HashMap<BitSet, Integer> counter = new HashMap<>();
        for (String input: inputs) {
            counter.put(sketch(input), 0);
        }
        for (String query: queries) {
            BitSet sketch = sketch(query);
            Integer alreadySet = counter.get(sketch);
            if (alreadySet != null) {
                counter.put(sketch, alreadySet+1);
            }
        }

        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Integer count = counter.get(sketch(queries[i]));
            ret[i] = count == null ? 0 : count;
        }
        return ret;
    }
}
