package sorting.binarysearch;

import java.util.*;

public class MaxSubarraySize {


    public static int maxSubarraySize(ArrayList<Integer> A, int B) {
        int low = 1, high = A.size();
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(A, B, mid)) {
                result = mid; // Update result
                low = mid + 1; // Try a larger subarray
            } else {
                high = mid - 1; // Reduce the subarray size
            }
        }
        return result;
    }

    // Function to check if a subarray of size `K` has all sums ≤ B
    private static boolean isValid(ArrayList<Integer> A, int B, int K) {
        long sum = 0;

        // Compute sum of first `K` elements
        for (int i = 0; i < K; i++) {
            sum += A.get(i);
        }

        // If first subarray sum > B, return false
        if (sum > B) return false;

        // Sliding Window: Update sum for remaining subarrays
        for (int i = K; i < A.size(); i++) {
            sum += A.get(i) - A.get(i - K);
            if (sum > B) return false;
        }

        return true; // No subarray of size `K` exceeded `B`
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int B = 10;
        System.out.println(maxSubarraySize(A, B)); // Output: 3
        /*
        Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.



Problem Constraints

1 <= |A| <= 100000
1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format

The first argument given is the integer array A.

The second argument given is integer B.



Output Format

Return the maximum value of K (sub array length).
         */
    }
}
