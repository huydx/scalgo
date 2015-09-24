package algorithm.crackingcode;

//Given a circular linked list, implement an algorithm
//which returns node at the begin- ning of the loop.
//use two moving pointer with different speed

import algorithm.datastructure.LinkedListNode;

public class CrkProblem25 {
    public static LinkedListNode findCircular(LinkedListNode head) {
        LinkedListNode pointer1 = head;
        LinkedListNode pointer2 = head;

        //learning : while(pointer1 != pointer) not seems to be worked
        while (pointer2.next != null) {
            pointer1 = pointer1.next; //jump1
            pointer2 = pointer2.next.next; //jump2

            if (pointer1 == pointer2) {
                break;
            }
        }

        if (pointer2.next == null) {
            return null;
        }

        pointer1 = head; //move to first
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer2;
    }

    public static void main(String[] args) {

    }
}
