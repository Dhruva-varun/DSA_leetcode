package Easy_Leetcode;

public class p1_Reverse_Linked_List {

    public static Node reverseList(Node head) {

        // iterative
        Node cur = head, prev = null;

        while (cur != null) {

            Node next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }
        return prev;

        // recursive
        // if(head==null || head.next==null) return head;

        // Node newHead = reverseList(head.next);
        // head.next.next = head;
        // head.next=null;

        // return newHead;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        PrintList.printLL(head);
        head = reverseList(head);
        PrintList.printLL(head);

    }

}