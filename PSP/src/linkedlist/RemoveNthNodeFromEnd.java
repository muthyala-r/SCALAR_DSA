package linkedlist;



public class RemoveNthNodeFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int B) {
        if (head == null) return null; // Edge case: Empty list
        
        ListNode fast = head;
        ListNode slow = head;

        // Move fast pointer B steps ahead
        for (int i = 0; i < B; i++) {
            if (fast.next == null) {
                // If B >= size of list, remove the head
                return head.next;
            }
            fast = fast.next;
        }

        // Move both pointers until fast reaches the last node
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the next node (B-th from end)
        slow.next = slow.next.next;

        return head;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        int B = 2; // Remove 2nd node from the end
        head = removeNthFromEnd(head, B);

        System.out.println("List after removing " + B + "-th node from end:");
        printList(head);
    }
}
