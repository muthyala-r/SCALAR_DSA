package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class DeepCopy {

    /**
     * Definition for singly-linked list with a random pointer.
     * class RandomListNode {
     *     int label;
     *     RandomListNode next, random;
     *     RandomListNode(int x) { this.label = x; }
     * };
     */
    private HashMap< RandomListNode, RandomListNode > hashMap;
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode node, newHead, newNode;
        hashMap = new HashMap < > ();
        node = head;
        newHead = null;
        while (node != null) {
            newNode = new RandomListNode(node.val);
            if (newHead == null)
                newHead = newNode;
            hashMap.put(node, newNode);
            node = node.next;
        }
        for (Map.Entry < RandomListNode, RandomListNode > entry: hashMap.entrySet()) {
            node = entry.getKey();
            newNode = entry.getValue();
            if (node.next != null) {
                newNode.next = hashMap.get(node.next);
            }
            if (node.random != null) {
                newNode.random = hashMap.get(node.random);
            }
        }
        return newHead;
    }

}
