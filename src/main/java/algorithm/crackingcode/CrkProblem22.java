package algorithm.crackingcode;

//Implement an algorithm to find the nth to last element of a singly linked list.

import algorithm.datastructure.LinkedListNode;

public class CrkProblem22 {
    public static LinkedListNode nThToLast(LinkedListNode head, int n) {
        LinkedListNode current = head;
        while (current.next != null) {
            LinkedListNode iterate = current.next;
            //check for next nth value is null or not
            //NOTE!!! not every time need to iterate all 1->n
            //just keep first and last nth node, and then increase both
            for (int i = 1; i <= n; i++) {
                if (iterate.next == null && i != n) { //check iterate.next
                    throw new RuntimeException("list size below n");
                } else if (i == n) {
                    if (iterate.next == null) return current;
                    else break; //increase current
                }
                iterate = iterate.next;
            }
            current = current.next;
        }

        if (n == 0) {
            return current;
        } else {
            return null; //not reach here
        }
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(0);
        head.appendTail(1).appendTail(2).appendTail(3).appendTail(4).appendTail(5).appendTail(6);
        System.out.println(nThToLast(head, 3).data);
    }
}
