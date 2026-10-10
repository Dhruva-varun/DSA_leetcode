package Hard_Leetcode;

// https://www.geeksforgeeks.org/problems/multiply-two-linked-lists/1

public class Q7_Multiply_two_numbers_represented_by_Linked_Lists {

    static final long MOD = 1000000007L; // given in the problem statement

    // Using Modular Arithmetic - O(n + m) Time and O(1) Space:
    // -> The numbers represented by the linked lists can be extremely large,
    // -> making it impossible to store them in built-in integer types without
    // overflow.
    // -> Instead of constructing the complete numbers, we compute their values
    // modulo 10^9 + 7 while traversing the linked lists.
    // -> So, while forming each number, we repeatedly take modulo to keep the
    // intermediate values within range.

    static int multiplyTwoLists(Node first, Node second) {

        long n1 = 0, n2 = 0;

        while (first != null) {
            n1 = (n1 * 10 + first.data) % MOD;
            first = first.next;
        }

        while (second != null) {
            n2 = (n2 * 10 + second.data) % MOD;
            second = second.next;
        }

        return (int) ((n1 * n2) % MOD);

    }

    public static void main(String[] args) {

        Node first = new Node(9);
        first.next = new Node(4);
        first.next.next = new Node(6);

        Node second = new Node(8);
        second.next = new Node(4);

        System.out.println(multiplyTwoLists(first, second));
    }
}
