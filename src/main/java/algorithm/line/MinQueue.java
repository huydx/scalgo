package algorithm.line;

import java.util.Collection;
import java.util.PriorityQueue;

public class MinQueue<V extends Comparable> {
    private PriorityQueue<V> store;
    public MinQueue(Collection<V> collection) {
        store = new PriorityQueue<>(collection);
    }

    void add (V value) {
        store.add(value);
    }

    V remove() {
        return store.remove();
    }

    V min() {
        return store.peek();
    }
}
