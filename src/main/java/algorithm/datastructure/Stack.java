package algorithm.datastructure;

public class Stack {
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

    public int peek() {
        return array[length];
    }

    public boolean isEmpty() {
        return (length == 0);
    }
}
