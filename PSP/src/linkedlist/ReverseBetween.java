package linkedlist;



public class ReverseBetween {
    public static ListNode reverseBetween(ListNode head, int B, int C) {
        if (head == null || B == C) return head; // No need to reverse if B == C

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: Reach (B-1)th node
        for (int i = 1; i < B; i++) {
            prev = prev.next;
        }

        // Step 2: Reverse sublist from B to C
        ListNode curr = prev.next; 
        ListNode next;
        ListNode subListTail = curr; // The tail of the reversed sublist

        ListNode prevReversed = null;
        for (int i = 0; i <= C - B; i++) {
            next = curr.next;
            curr.next = prevReversed;
            prevReversed = curr;
            curr = next;
        }

        // Step 3: Connect reversed part back
        prev.next = prevReversed;
        subListTail.next = curr;

        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        int B = 2, C = 4;
        head = reverseBetween(head, B, C);

        System.out.println("List after reversing from " + B + " to " + C + ":");
        printList(head);
    }
}
