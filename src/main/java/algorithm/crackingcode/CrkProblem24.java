package algorithm.crackingcode;

//You have two numbers represented by a linked list, where each node
// contains a sin- gle digit. The digits are stored in reverse order,
// such that the 1’s digit is at the head of the list. Write a function
// that adds the two numbers and returns the sum as a linked list.
//EXAMPLE
//        Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
//        Output: 8 -> 0 -> 8


//note: implement using recursive seems better!!!!

import algorithm.datastructure.LinkedListNode;

public class CrkProblem24 {
    public static LinkedListNode sum(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode iter1 = l1;
        LinkedListNode iter2 = l2;
        int memory = 0;
        int firstDigit = iter1.data + iter2.data;
        if (firstDigit >= 10) {
            firstDigit = firstDigit - 10;
            memory = 1;
        }
        LinkedListNode sum = new LinkedListNode(firstDigit);

        while (iter1.next != null && iter2.next != null) {
            int digit = iter1.next.data + iter2.next.data + memory;
            if (digit >= 10) {
                sum.appendTail(digit-10);
                memory = 1;
            } else {
                sum.appendTail(digit);
                memory = 0;
            }
            iter1 = iter1.next;
            iter2 = iter2.next;
        }

        if (iter1.next == null && iter2.next != null) {
            while (iter2.next != null) {
                sum.appendTail(iter2.next.data);
                iter2 = iter2.next;
            }
        } else if (iter2.next == null && iter1.next != null){
            while (iter1.next != null) {
                sum.appendTail(iter1.next.data);
                iter1 = iter1.next;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode(3);
        LinkedListNode l2 = new LinkedListNode(5);
        l2.appendTail(9).appendTail(2);

        LinkedListNode ret = sum(l1, l2);
        System.out.println(ret.data + " -> " + ret.next.data + " -> " + ret.next.next.data);
    }
}
