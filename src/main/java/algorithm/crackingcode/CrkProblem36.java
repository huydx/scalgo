package algorithm.crackingcode;

//Write a program to sort a stack in ascending order.
//You should not make any assump- tions about how the stack is implemented.
//The following are the only functions that should be used to write this program: push | pop | peek | isEmpty.


//idea is, use a buffer
//pop from in, push to buffer
//eat time pop from in, push back from buffer to in if pop-ed data is greater than buffer
//push back from buffer to in is the point

import algorithm.datastructure.Stack;

public class CrkProblem36 {

    public static Stack sort(Stack in) {
        Stack buffer = new Stack();
        while (!in.isEmpty()) {
            int tmp = in.pop();
            while (!buffer.isEmpty() && buffer.peek() > tmp) {
                in.push(buffer.pop());
            }
            buffer.push(tmp);
        }
        return buffer;
    }

    public static void main(String[] args) {
        Stack in = new Stack();
        in.push(1);
        in.push(5);
        in.push(2);
        in.push(9);
        in.push(10);

        Stack out = sort(in);
        System.out.print(out.pop());
        System.out.print(out.pop());
        System.out.print(out.pop());
        System.out.print(out.pop());
        System.out.print(out.pop());
    }

}
