package linkedlist;

public class InsertNodeInLinkedList {
    public static ListNode insertNode(ListNode head, int B, int C) {
        ListNode newNode = new ListNode(B);

        // Case 1: Insert at head (position 0) or empty list
        if (head == null || C == 0) {
            newNode.next = head;
            return newNode;
        }

        ListNode temp = head;
        int count = 0;

        // Traverse to the node before position C
        while (temp.next != null && count < C - 1) {
            temp = temp.next;
            count++;
        }

        // Case 2: Insert at the tail (if C is out of range)
        // No need to check explicitly, just insert at temp.next
        newNode.next = temp.next;
        temp.next = newNode;

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
        // Test 1: Inserting into a single-node list
        ListNode head = new ListNode(10);
        System.out.println("Original List:");
        printLinkedList(head);

        head = insertNode(head, 20, 1); // Inserting at tail
        System.out.println("After Inserting 20 at position 1:");
        printLinkedList(head);

        head = insertNode(head, 5, 0); // Inserting at head
        System.out.println("After Inserting 5 at position 0:");
        printLinkedList(head);

        // Test 2: Empty list case
        ListNode emptyHead = null;
        emptyHead = insertNode(emptyHead, 100, 0); // Insert in an empty list
        System.out.println("After inserting 100 in an empty list:");
        printLinkedList(emptyHead);
    }
}
