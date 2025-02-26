package linkedlist;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListPrinter {
    public static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " "); // Print value followed by space
            temp = temp.next;
        }
        System.out.println(); // Print a newline at the end
    }

    public static void main(String[] args) {
        // Creating a linked list: 1 -> 2 -> 3
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);

        // Print the linked list
        printLinkedList(A);
    }
}
