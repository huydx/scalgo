package algorithm.line;

import java.util.*;
import static java.util.Arrays.*;

public class CycleFinder2 {

    public static class Node {
        public int vertex;
        public int level;
        public Node parent;

        public Node(int v, int l) {
            vertex = v;
            level = l;
        }
    }

    public void findCycle(boolean[][] graph, int m) {
        Stack<Node> stack = new Stack<>();
        Map<Integer, Boolean> visit = new HashMap<>();
        int graphLength = graph[0].length;

        stack.push(new Node(0, 0));
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            int currentLevel = currentNode.level;
            if (!visit.containsKey(currentNode.vertex)) {
                //mark currentNode as visited
                visit.put(currentNode.vertex, true);
                int vert = currentNode.vertex;

                //add all currentNode neighbor to currentNode
                for (int i = 0; i < graphLength; i++) {
                    if (graph[i][vert]) {
                        Node n = new Node(i, currentLevel + 1);
                        n.parent = currentNode;
                        stack.push(n);
                    }
                }
            } else {
                //found cycle
                if (currentNode.parent != null) {
                    int len = Math.abs(currentNode.parent.level - currentLevel) + 1;
                    if (len == m) {
                        System.out.println("found cycle");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        boolean[][] graph = {
                {false, true, true} ,
                {true, false, true} ,
                {true, true, false}
        };
        new CycleFinder2().findCycle(graph, 3);
    }

    public void debug(Object... obj) {
        deepToString(obj);
    }
}
