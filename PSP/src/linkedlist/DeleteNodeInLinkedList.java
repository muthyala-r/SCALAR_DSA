package linkedlist;



public class DeleteNodeInLinkedList {
    public static ListNode deleteNode(ListNode head, int B) {
        // Case 1: If the list is empty
        if (head == null) return null;

        // Case 2: If deleting the head node (B == 0)
        if (B == 0) {
            return head.next; // New head is the next node
        }

        ListNode temp = head;
        int count = 0;

        // Traverse to the node before the B-th node
        while (temp != null && count < B - 1) {
            temp = temp.next;
            count++;
        }

        // Case 3: If B is out of range, return original list
        if (temp == null || temp.next == null) {
            return head;
        }

        // Case 4: Delete the B-th node
        temp.next = temp.next.next;

        return head;
    }

    public static void printLinkedList(ListNode head) {
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
        printLinkedList(head);

        // Delete node at position 2 (0-based index): Expected list: 1 -> 2 -> 4 -> 5
        head = deleteNode(head, 2);
        System.out.println("After Deleting Node at Position 2:");
        printLinkedList(head);

        // Delete node at position 0 (delete head): Expected list: 2 -> 4 -> 5
        head = deleteNode(head, 0);
        System.out.println("After Deleting Node at Position 0:");
        printLinkedList(head);

        // Delete node at last position (delete tail): Expected list: 2 -> 4
        head = deleteNode(head, 2);
        System.out.println("After Deleting Last Node:");
        printLinkedList(head);
    }
}
