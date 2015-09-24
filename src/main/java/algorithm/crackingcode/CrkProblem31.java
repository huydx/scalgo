package algorithm.crackingcode;

import algorithm.datastructure.Stack;

import java.util.Arrays;

//Describe how you could use a single array to implement three stacks.
//the problem is hard when we need 3 stacks able to span freely using free space in array
//to overcome that, we need to use a special Node which point to "previous"

//learning: Node rule it all!!

public class CrkProblem31 {

    static class My3Stack {
        final private int MAX_SIZE = 1024;
        int[] array = new int[MAX_SIZE];
        int[] pointers = new int[] {0,0,0};
        int[] starts = new int[] {0, MAX_SIZE/3, MAX_SIZE*2/3};

        public void push(int item, int stackNum) {
            int newPointer = starts[stackNum] + pointers[stackNum] + 1;
            array[newPointer] = item;
            pointers[stackNum] = newPointer;
        }

        public int pop(int stackNum) {
            if (pointers[stackNum] <= starts[stackNum]) {
                throw new RuntimeException("stack is empty");
            }
            int ret = array[pointers[stackNum]];
            pointers[stackNum]--;
            return ret;
        }

        public void println() {
            System.out.println(Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        My3Stack stack = new My3Stack();
        stack.push(0, 0);
        stack.push(1, 0);
        stack.push(2, 0);
        stack.pop(0);
        stack.pop(0);
        stack.pop(0);
        stack.println();

    }
}
