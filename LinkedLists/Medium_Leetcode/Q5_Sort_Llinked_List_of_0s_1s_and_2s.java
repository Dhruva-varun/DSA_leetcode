package Medium_Leetcode;

// https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1

public class Q5_Sort_Llinked_List_of_0s_1s_and_2s {

    public static Node sortList(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        // By Maintaining Frequency - O(n) Time and O(1) Space:
        // -> The idea is to traverse the linked List and count the number of nodes
        // having values 0, 1 and 2.
        // -> Now, traverse the linked list again to fill the first count[0] nodes with
        // 0, then next count[1] nodes with 1
        // and finally count[2] nodes with 2.

        /*
         * int count0 = 0, count1 = 0, count2 = 0;
         * Node temp = head;
         * while (temp != null) {
         * if (temp.data == 0) {
         * count0++;
         * } else if (temp.data == 1) {
         * count1++;
         * } else {
         * count2++;
         * }
         * temp = temp.next;
         * }
         * 
         * temp = head;
         * 
         * while(count0!=0){
         * temp.data = 0;
         * temp = temp.next;
         * count0--;
         * }
         * 
         * while(count1!=0){
         * temp.data = 1;
         * temp = temp.next;
         * count1--;
         * }
         * 
         * while(count2!=0){
         * temp.data = 2;
         * temp = temp.next;
         * count2--;
         * }
         * 
         * while (temp != null) {
         * if (count0 > 0) {
         * temp.data = 0;
         * count0--;
         * } else if (count1 > 0) {
         * temp.data = 1;
         * count1--;
         * } else {
         * temp.data = 2;
         * count2--;
         * }
         * temp = temp.next;
         * }
         * 
         * return head;
         */

        // By Updating Links of Nodes - O(n) Time and O(1) Space:
        // -> The idea is to maintain 3 pointers named zero, one and two to point to
        // current ending nodes of linked lists containing 0, 1, and 2 respectively.
        // -> If the current node's value is 0, append it after pointer zero and move
        // pointer zero to current node.
        // -> If the current node's value is 1, append it after pointer one and move
        // pointer one to current node.
        // -> If the current node's value is 2, append it after pointer two and move
        // pointer two to current node.
        // -> Finally, we link all three lists.
        // -> To avoid many null checks, we use three dummy pointers zeroD, oneD and
        // twoD that work as dummy headers of three lists.

        Node zeroD = new Node(0);
        Node oneD = new Node(0);
        Node twoD = new Node(0);

        Node zero = zeroD;
        Node one = oneD;
        Node two = twoD;

        Node curr = head;

        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }

            curr = curr.next;
        }

        zero.next = (oneD.next != null) ? oneD.next : twoD.next;
        one.next = twoD.next;
        two.next = null;

        return zeroD.next;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(0);

        PrintList.printLL(head);
        head = sortList(head);
        PrintList.printLL(head);
    }

}
