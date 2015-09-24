package algorithm.crackingcode;

import algorithm.datastructure.LinkedListNode;

import java.util.HashMap;

//Write code to remove duplicates from an unsorted linked list.
//try without buffer
//** learning
//  - delete mutable data lead to some un-expected behaviour
//  - delete node by manual setting null in linkedlist lead to lest un-expected behaviour
//  - deleting node really error proning!!!! be careful!!


public class CrkProblem21 {
    public static LinkedListNode removeDuplicated(LinkedListNode head) {
        HashMap<Integer, Boolean> checker = new HashMap<>();
        LinkedListNode ret = new LinkedListNode(head.data);
        LinkedListNode n = head;

        while (n.next != null) {
            int dat = n.next.data;
            if (!checker.containsKey(dat)) {
                ret.appendTail(dat);
                checker.put(dat, true);
            }
            n = n.next;
        }
        return ret;
    }

    //use two pointer to iterate -> therefore can be able to not use buffer
    //current does iteration
    //runner check duplicate
    public static void removeDuplicatedEff(LinkedListNode head) {
        LinkedListNode current = head;
        while (current.next != null) {
            LinkedListNode duplicateChecker = current;
            int dat = current.data;
            while (duplicateChecker.next != null) {
                if (duplicateChecker.next.data == dat) {
                    //remove current node
                    if (duplicateChecker.next.next != null) {
                        duplicateChecker.next = duplicateChecker.next.next;
                    } else {
                        duplicateChecker.next = null;
                        break; //easy to forget
                    }
                }
                duplicateChecker = duplicateChecker.next;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(0);
        head.appendTail(5).appendTail(6).appendTail(5).appendTail(6).appendTail(7).appendTail(5);
        removeDuplicatedEff(head);
        System.out.println(head.next.next.data);
    }
}
