package algorithm.crackingcode;

//How would you design a stack which, in addition to push and pop, also has a function min which
//returns the minimum element? Push, pop and min should all operate in O(1) time.

//we use a second stack to keep track of min values
//learning:
// min is node-realted, so if we don't want another stack, we must use a Node with two value: one is real data, and one is min data at pushed time

public class CrkProblem32 {

    static class AdvanceStack { //learn: inner class must be static to be referenced from parent class
        private int[] array;
        private int[] minArray;
        public int length = 0;

        public AdvanceStack() {
            final int MAX_LENGTH = 1024;
            array = new int[MAX_LENGTH];
            minArray = new int[MAX_LENGTH];
            minArray[0] = Integer.MAX_VALUE; //learn: first time initialize for min array
            length = 0;
        }

        public void push(int item) { //learn: first time check, when minArray not exist
            int minAtThisTime = minArray[length];
            int m = -1;
            m = item < minAtThisTime ? item : minAtThisTime;
            length++;

            array[length] = item;
            minArray[length] = m;
        }

        public int pop() {
            int ret = array[length];
            length--;
            return ret;
        }

        public int min() {
            return minArray[length];
        }
    }


    public static void main(String[] args) {
        AdvanceStack stack = new AdvanceStack();
        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.pop();
        System.out.print(stack.min());
    }
}
