package algorithm.line;

import java.util.HashMap;

public class LruCache<K, V> {
    int capacity;
    HashMap<K, Node> map = new HashMap<>();
    Node head = null;
    Node tail = null;

    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    static class Node<K, V> {
        K key;
        V value;
        Node pre;
        Node next;
        public Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    public void remove(Node n) {
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }

        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            tail = n.pre;
        }

    }

    public void setHead(Node n) {
        n.next = head;
        n.pre = null;
        if (head != null) {
            head.pre = n;
        }
        head = n;
        if (tail == null) {
            tail = head;
        }
    }

    void add(K key, V value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node newNode = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(tail.key);
                remove(tail);
                setHead(newNode);

            }else{
                setHead(newNode);
            }

            map.put(key, newNode);
        }
    }

    public V get(K key) {
        Node n = getNode(key);
        if (n != null) {
            return (V)n.value;
        }
        return null;
    }

    public Node getNode(K key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n;
        }
        return null;
    }

    V remove(K key) {
        Node n = getNode(key);
        V value = (V)n.value;
        remove(n);
        return value;
    }

    void evict() {
        remove(tail);
    }

    public static void main(String[] args) {

    }
}
