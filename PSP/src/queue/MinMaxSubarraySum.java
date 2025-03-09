package queue;

import java.util.*;

public class MinMaxSubarraySum {
    public static int sumOfMinMax(int[] A, int B) {
        int MOD = 1000000007;
        int n = A.length;
        long sum = 0;

        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements out of the current window from the front
            if (!maxDeque.isEmpty() && maxDeque.peekFirst() < i - B + 1) {
                maxDeque.pollFirst();
            }
            if (!minDeque.isEmpty() && minDeque.peekFirst() < i - B + 1) {
                minDeque.pollFirst();
            }

            // Remove elements from the back if they are smaller than current (for maxDeque)
            while (!maxDeque.isEmpty() && A[maxDeque.peekLast()] <= A[i]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(i);

            // Remove elements from the back if they are larger than current (for minDeque)
            while (!minDeque.isEmpty() && A[minDeque.peekLast()] >= A[i]) {
                minDeque.pollLast();
            }
            minDeque.addLast(i);

            // Start adding to the sum once we have processed at least B elements
            if (i >= B - 1) {
                sum = (sum + A[maxDeque.peekFirst()] + A[minDeque.peekFirst()]) % MOD;
            }
        }

        return (int) sum;
    }

    public static void main(String[] args) {
        int[] A1 = {2, 5, -1, 7, -3, -1, -2};
        int B1 = 4;
        System.out.println(sumOfMinMax(A1, B1)); // Output: 18

        int[] A2 = {2, -1, 3};
        int B2 = 2;
        System.out.println(sumOfMinMax(A2, B2)); // Output: 3
    }
}
