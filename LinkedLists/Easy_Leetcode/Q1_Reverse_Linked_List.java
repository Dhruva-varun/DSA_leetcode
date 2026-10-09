package Easy_Leetcode;

public class Q1_Reverse_Linked_List {

    public static Node reverseList(Node head) {

        // Using Iterative Method - O(n) Time and O(1) Space
        // -> The idea is to reverse the linked list by changing the direction of links
        // using three pointers: prev, curr, and next.
        // -> At each step, point the current node to its previous node and then move
        // all three pointers forward until the list is fully reversed.
        Node cur = head, prev = null;

        while (cur != null) {

            Node next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }
        return prev;

        // Using Recursion Method- O(n) Time and O(n) Space
        // -> The idea is to use recursion to reach the last node of the list, which
        // becomes the new head after reversal.
        // -> As the recursion starts returning, each node makes its next node next
        // [head.next.next] point back to itself [=head].
        // -> effectively reversing the links one by one until the entire list is
        // reversed.

        /*
         * if(head==null || head.next==null) return head;
         * 
         * Node newHead = reverseList(head.next);
         * head.next.next = head;
         * head.next=null;
         * 
         * return newHead;
         */
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