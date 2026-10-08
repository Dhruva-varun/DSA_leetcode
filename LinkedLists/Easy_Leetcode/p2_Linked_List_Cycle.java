package Easy_Leetcode;

import java.util.HashSet;

public class p2_Linked_List_Cycle {

    public static boolean hasCycle(Node head) {

        //Using Floyd's Cycle Detection Algorithm (Tortoise and Hare) - O(n) Time and O(1) Space
        // Step 1: Presence of the cycle:
        // -> Take two pointers $slow and $fast.
        // -> Both of them will point to head of the linked list initially.
        // -> $slow will move one step at a time. $fast will move two steps at a time. (twice as speed as $slow$ pointer).
        // -> Check if at any point they point to the same node before any one(or both) reach null.
        // -> If they point to the same node at any point of their journey, it indicates that a cycle indeed exists in the linked list.
        // -> If we get null, it indicates that the linked list has no cycle.

        Node slow = head, fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return true;
        }
        return false;

        //Using HashSet to track visited nodes. - O(n) Time and O(n) Space

        // HashSet<Node> visited = new HashSet<>();

        // while(head!=null){
            
        //     if(!visited.add(head)){
        //         return true;
        //     }
        //     head = head.next;
        // }
        // return false;

    }


    public static void main(String[] args) {
        Node head = new Node(1);
        Node one = new Node(2);
        Node two = new Node(3);
        Node three = new Node(4);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = one;

        System.out.println(hasCycle(head));
    }
}
