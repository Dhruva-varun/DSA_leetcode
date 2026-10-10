package Easy_Leetcode;

import java.util.HashSet;

// https://www.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1

public class Q6_Remove_Duplicates_from_Linked_List {

    public static Node removeDuplicatesUnsorted(Node head) {

        if (head == null) {
            return null;
        }

        // Using Hash Set - O(n) Time and O(n) Space
        HashSet<Integer> seen = new HashSet<>();

        Node curr = head;
        Node prev = null;

        while (curr != null) {
            if (seen.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                seen.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }

        return head;

        // By Checking Every Previous Node - O(n ^ 2) Time and O(1) Space:
        /*
         * Node curr = head;
         * 
         * while(curr!=null){
         * 
         * Node prev = curr;
         * Node temp = curr.next;
         * 
         * while(temp!=null){
         * if(curr.data == temp.data){
         * prev.next = temp.next;
         * }else{
         * prev = temp;
         * }
         * 
         * temp=temp.next;
         * }
         * curr = curr.next;
         * }
         * 
         * return head;
         */

    }

    public static Node deleteDuplicatesSorted(Node head) {

        if (head == null) {
            return null;
        }

        // O(n) Time and O(1) Space

        Node curr = head;

        while (curr != null && curr.next != null) {

            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Node list1 = new Node(10);
        list1.next = new Node(5);
        list1.next.next = new Node(10);
        list1.next.next.next = new Node(2);
        list1.next.next.next.next = new Node(2);

        Node list2 = new Node(1);
        list2.next = new Node(2);
        list2.next.next = new Node(2);
        list2.next.next.next = new Node(4);
        list2.next.next.next.next = new Node(5);

        PrintList.printLL(list1);
        PrintList.printLL(removeDuplicatesUnsorted(list1));

        PrintList.printLL(list2);
        PrintList.printLL(deleteDuplicatesSorted(list2));

    }
}
