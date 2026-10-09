package Medium_Leetcode;

public class Q4_Delete_Node_in_a_Linked_List_without_head {

    public static void deleteNode(Node node) {

        // Copy Data of Next Node - O(1) Time and O(1) Space:
        // -> Store the next node of the given node.
        // -> Copy the next node's data into the given node.
        // -> Update the given node's next pointer to skip the next node.
        // -> Delete the skipped node.
        // -> The linked list size decreases by one.

        // -> Input: head = 10 -> 20 -> 4 -> 30, x = 20
        // -> Store the next node (4) in a temporary pointer.
        // -> Copy the data of the next node (4) into x. The list becomes: 10 -> 4 -> 4
        // -> 30.
        // -> Update the next pointer of x to skip the copied node. The list becomes: 10
        // -> 4 -> 30.
        // -> Delete the skipped node (4), reducing the size of the linked list by one.

        Node temp = node.next;
        node.data = temp.data;
        node.next = temp.next;
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(4);
        head.next.next.next = new Node(30);

        Node node = head.next;

        PrintList.printLL(head);
        deleteNode(node);
        PrintList.printLL(head);
    }
}
