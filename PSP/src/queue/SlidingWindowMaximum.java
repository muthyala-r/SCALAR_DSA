package queue;

import java.util.*;

public class SlidingWindowMaximum {
    public static List<Integer> maxSlidingWindow(int[] A, int B) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < A.length; i++) {
            // Remove elements that are out of this window
            if (!deque.isEmpty() && deque.peekFirst() < i - B + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements as they are useless
            while (!deque.isEmpty() && A[deque.peekLast()] <= A[i]) {
                deque.pollLast();
            }

            // Add the current index to deque
            deque.offerLast(i);

            // Only add to result when we have a valid window
            if (i >= B - 1) {
                result.add(A[deque.peekFirst()]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int B1 = 3;
        System.out.println(maxSlidingWindow(A1, B1)); // Output: [3, 3, 5, 5, 6, 7]

        int[] A2 = {1, 2, 3, 4, 2, 7, 1, 3, 6};
        int B2 = 6;
        System.out.println(maxSlidingWindow(A2, B2)); // Output: [7, 7, 7, 7]
    }
}
