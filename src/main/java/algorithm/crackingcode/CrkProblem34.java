package algorithm.crackingcode;

import algorithm.datastructure.Stack;

// problem of the Towers of Hanoi, you have 3 rods and N disks of different sizes which can slide onto any tower.
// The puzzle starts with disks sorted in ascending order of size from top to bottom
// (e.g., each disk sits on top of an even larger one).
// You have the following constraints:
//(A) Only one disk can be moved at a time.
//(B) A disk is slid off the top of one rod onto the next rod.
//(C) A disk can only be placed on top of a larger disk.

public class CrkProblem34 {
    static class Tower {
        private Stack disks;
        private int index;

        public Tower(int i) {
            disks = new Stack();
            index = i;
        }

        public int index() { return index;}

        public void add(int d) {
            if (!disks.isEmpty() && disks.pop() <= d) {
                System.out.println("Error placing disk " + d);
            } else {
                disks.push(d);
            }
        }

        public void moveTopTo(Tower t) {
            int top = disks.pop();
            t.add(top);
        }

        public void moveDisks(int n, Tower destination, Tower buffer) {
            if (n > 0) {
                moveDisks(n - 1, buffer, destination);
                moveTopTo(destination);
                buffer.moveDisks(n - 1, destination, this);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        Tower[] towers = new Tower[n];
        for (int i = 0; i < 3; i++) towers[i] = new Tower(i);
        for (int i = n - 1; i >= 0; i--) towers[0].add(i);
        towers[0].moveDisks(n, towers[2], towers[1]);
    }
}
