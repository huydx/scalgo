package algorithm.datastructure;

public class LinkedListNode {
    public LinkedListNode next = null;
    public int data;
    public int length = 0;

    public LinkedListNode(int d) {
        data = d;
    }

    public LinkedListNode appendTail(int d) {
        LinkedListNode n = new LinkedListNode(d);
        LinkedListNode traverse = this;
        while (traverse.next != null) {
            traverse = traverse.next;
        }
        this.length++;
        traverse.next = n;
        return traverse;
    }

    public static LinkedListNode deleteNode(LinkedListNode head, int d) {
        LinkedListNode n = head;
        if (n.data == d) {
            return head.next;
        }
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                n.next = null; //remove node
                head.length--;
                return head;
            }
            n = n.next;
        }
        throw new RuntimeException("not found data: "+ d);
    }
}


