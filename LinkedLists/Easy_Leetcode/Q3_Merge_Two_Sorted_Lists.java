package Easy_Leetcode;

public class Q3_Merge_Two_Sorted_Lists {
    
    public static Node mergeTwoLists(Node list1, Node list2) {

        // Using Iterative Method - O(n X m) Time and O(1) Space
        // -> The idea is to create a new linked list by comparing the values of the nodes in the two input lists.
        // -> We use a dummy node to simplify the process of building the new list. 
        // -> We iterate through both lists, adding the smaller node to the new list and moving the pointer of that list forward.
        // -> Once we reach the end of one list, we append the remaining nodes of the other list to the new list.

        Node dummy = new Node(-1);
        Node cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 != null) {
            cur.next = list1;
        } else {
            cur.next = list2;
        }

        return dummy.next;

        

        //Using Recursive Merge - O(n+m) Time and O(n+m) Space
        // -> If list1 is null, return list2.
        // -> If list2 is null, return list1.
        // -> If list1.data <= list2.data, recursively merge list1->next and list2, and link the result with list1.next.
        // -> Otherwise, recursively merge list1 and list2->next, and link the result with list2.next.
        // -> Return the first node of the merged list.

        // if(list1==null || list2==null){
        //     return list1==null ? list2 : list1;
        // }

        // if(list1.data <= list2.data){
        //     list1.next = mergeTwoLists(list1.next,list2);
        //     return list1;
        // }else{
        //     list2.next = mergeTwoLists(list1,list2.next);
        //     return list2;
        // }

    }

     public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(3);
        list1.next.next.next = new Node(4);
        list1.next.next.next.next = new Node(5);

        Node list2 = new Node(1);
        list2.next = new Node(2);
        list2.next.next = new Node(3);
        list2.next.next.next = new Node(4);
        list2.next.next.next.next = new Node(5);

        PrintList.printLL(list1);
        PrintList.printLL(list2);
        Node list3 = mergeTwoLists(list1, list2);
        PrintList.printLL(list3);

    }

    
}
