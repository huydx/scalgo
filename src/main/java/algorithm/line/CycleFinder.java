package algorithm.line;
import java.util.Stack;

public class CycleFinder {
    public static void findCycle(boolean[][] graph, int m) {
        //use dfs to search for cycle
        int size = graph[0].length;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0 ; i < size; i++ ) {
            Stack<Integer> memoize = new Stack<Integer>();
            memoize.push(i);
            boolean[] visited = new boolean[size];
            findCycle2(graph, visited, stack, size, 0, m, memoize);
        }
    }

    public static void findCycle2(boolean[][] graph, boolean[] visited, Stack<Integer> stack, int size, int level, int m, Stack<Integer> memoize) {
        if (stack.isEmpty()) return;
        if (level > m) return;

        int toVisit = stack.pop();
        visited[toVisit] = true;

        for (int i = 0; i < size; i++) {
            if (visited[toVisit] && level == m) {
                //found!
                while (!memoize.isEmpty()) {
                    System.out.print(memoize.pop());
                }
                return;
            }
            if (!visited[toVisit] && graph[toVisit][i]) {
                memoize.push(toVisit);
                findCycle2(graph, visited, stack, size, 1, m, memoize);
                memoize.pop();
            }
        }
    }

    public static void main(String[] args) {
        boolean[][] graph = {{false, true, false, true}, {true, false, false, false}, {true, true, true, true}};
        findCycle(graph, 3);
    }

}
