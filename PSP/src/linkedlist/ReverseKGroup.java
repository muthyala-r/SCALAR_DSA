package linkedlist;



public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int B) {
        if (head == null || B == 1) return head; // No change if B = 1

        ListNode dummy = new ListNode(0); // Dummy node to track new head
        dummy.next = head;

        ListNode prevGroupEnd = dummy, curr = head;

        while (curr != null) {
            ListNode groupStart = curr;
            ListNode prev = null;
            int count = 0;

            // Reverse B nodes
            while (curr != null && count < B) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }

            // Connect previous group with the new reversed group
            prevGroupEnd.next = prev;
            groupStart.next = curr;

            // Move prevGroupEnd for next iteration
            prevGroupEnd = groupStart;
        }

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
        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println("Original List:");
        printList(head);

        int B = 2; // Reverse in groups of 2
        head = reverseKGroup(head, B);

        System.out.println("List after reversing in groups of " + B + ":");
        printList(head);
    }
}
