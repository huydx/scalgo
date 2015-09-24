package algorithm.crackingcode;

//SetOf- Stacks should be composed of several stacks, and should create a new stack once the previous one exceeds capacity.
//SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack
// (that is, pop() should return the same values as it would if there were just a single stack).


public class CrkProblem33 {
    static class Stack {
        public int[] array;
        public int length = 0;

        public Stack() {
            final int MAX_LENGTH = 1024; //learning: not auto expand array lead to this constant
            array = new int[MAX_LENGTH]; //learning: remember to add length zzz
            length = 0;
        }

        public void push(int item) {
            array[++length] = item; //learn: short code
        }

        public int pop() {
            return array[length--];
        }

        public boolean isEmpty() {
            return (length == 0);
        }
    }


    static class SetOfStacks {
        final private int THRESHOLD = 1;
        final private int MAXSTACKNUM = 100;
        Stack[] stackArray = new Stack[MAXSTACKNUM];
        private int stackIndex = 0;

        public SetOfStacks() {
            stackArray[0] = new Stack(); //learn: forgot initialize!!
        }

        public void push(int data) {
            Stack currentStack = stackArray[stackIndex];
            if (currentStack.length >= THRESHOLD) {
                Stack newStack = new Stack();
                stackArray[++stackIndex] = newStack;
                newStack.push(data);
            } else {
                currentStack.push(data);
            }
        }

        public int pop() {
            Stack currentStack = stackArray[stackIndex];
            if (currentStack.isEmpty()) {
                stackIndex--;
                if (stackIndex < 0) {
                    throw new RuntimeException("all stack is empty");
                } else {
                    Stack newStack = stackArray[stackIndex];
                    return newStack.pop();
                }
            } else {
                return currentStack.pop();
            }
        }

    }

    public static void main(String[] args) {
        SetOfStacks st = new SetOfStacks();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.pop();
        st.pop();
        st.pop();
        System.out.println(st.pop());
    }
}
