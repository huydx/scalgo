package algorithm.crackingcode;

//Implement an algorithm to delete a node in the middle of a single linked list,
//given only access to that node.
//Input: the node ‘c’ from the linked list a->b->c->d->e
//Result: nothing is returned, but the new linked list looks like a->b->d->e
//this is an interesting problem

import algorithm.datastructure.LinkedListNode;

public class CrkProblem23 {
    public static void removeNode(LinkedListNode toRemove) {
        LinkedListNode next = toRemove.next;
        toRemove.data = next.data;
        toRemove.next = next.next;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(0);
        head.appendTail(5).appendTail(6).appendTail(5).appendTail(6).appendTail(7).appendTail(5);
        removeNode(head);
        System.out.println(head.data);
    }
}
