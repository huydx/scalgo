package algorithm.datastructure;

import java.util.Iterator;

public class Graph {
    //vertex be describe as a 0~N number

    private int v;   //vertices number
    private int e; //edges number

    LinkedListNode[] adj = new LinkedListNode[1024];

    public int V() { return v; };
    public int E() { return e; };

    public void addEdge(int v, int w) {

    }

//    public Iterator<Integer> adj(int v) {
//
//    }

    public Graph() {

    }
}
