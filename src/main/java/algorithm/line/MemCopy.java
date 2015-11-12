package algorithm.line;

import java.util.Arrays;

public class MemCopy {
    public static void memcopy(byte[] v, int dest, int src, int size) {
        if (src + size > v.length || dest + size > v.length) {
            throw new RuntimeException("size invalid");
        }
        System.arraycopy(v, src, v, dest, v.length);
    }
}
