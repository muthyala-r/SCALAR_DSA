package linkedlist;

class RandomListNode {
    int val;
    RandomListNode next, random;

    RandomListNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class DeepCopyLinkedList {
    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        // Step 1: Create new cloned nodes and interweave them with the original list
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode copy = new RandomListNode(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Copy random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the cloned list from the original list
        curr = head;
        RandomListNode newHead = head.next;
        RandomListNode copyCurr = newHead;
        
        while (curr != null) {
            curr.next = curr.next.next;
            if (copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return newHead;
    }

    public static void printList(RandomListNode head) {
        RandomListNode temp = head;
        while (temp != null) {
            int randomVal = (temp.random != null) ? temp.random.val : -1;
            System.out.println("Node: " + temp.val + ", Random: " + randomVal);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a linked list: 1 -> 2 -> 3
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);

        // Assigning random pointers
        head.random = head.next.next; // 1 -> 3
        head.next.random = head; // 2 -> 1
        head.next.next.random = head.next; // 3 -> 2

        System.out.println("Original List:");
        printList(head);

        RandomListNode copiedHead = copyRandomList(head);

        System.out.println("Cloned List:");
        printList(copiedHead);
    }
}
