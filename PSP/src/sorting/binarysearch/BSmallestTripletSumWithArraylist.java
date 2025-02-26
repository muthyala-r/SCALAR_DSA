package sorting.binarysearch;

import java.util.ArrayList;
import java.util.Collections;

public class BSmallestTripletSumWithArraylist {
    public static void main(String[] args) {
        /*
        Given an integer array A of size N.

If we store the sum of each triplet of the array A in a new list, then find the Bth smallest element among the list.

NOTE: A triplet consists of three elements from the array. Let's say if A[i], A[j], A[k] are the elements of the triplet then i < j < k.
         */
    }

    public int solve(ArrayList<Integer> A, int B) {

        Collections.sort(A); // Step 1: Sort the ArrayList
        int n = A.size();
        int low = A.get(0) + A.get(1) + A.get(2);   // Minimum triplet sum
        int high = A.get(n-3) + A.get(n-2) + A.get(n-1); // Maximum triplet sum
        int result = low;

        // Binary search on possible triplet sums
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countTriplets(A, mid); // Count triplets with sum ≤ mid

            if (count >= B) { // If at least B triplets exist, move left
                result = mid;
                high = mid - 1;
            } else { // Otherwise, move right
                low = mid + 1;
            }
        }

        return result;
    }

    private  int countTriplets(ArrayList<Integer> A, int target) {
        int n = A.size();
        int count = 0;

        // Fix first element
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;

            // Two-pointer approach to find valid pairs
            while (left < right) {
                int sum = A.get(i) + A.get(left) + A.get(right);

                if (sum <= target) {
                    count += (right - left); // All pairs (left, left+1, ..., right) are valid
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}
