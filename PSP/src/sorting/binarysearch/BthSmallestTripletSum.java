package sorting.binarysearch;

import java.util.Arrays;

public class BthSmallestTripletSum {
    public static int findBthSmallestTripletSum(int[] A, int B) {
        Arrays.sort(A); // Step 1: Sort the array
        int n = A.length;
        int low = A[0] + A[1] + A[2];   // Minimum triplet sum
        int high = A[n-3] + A[n-2] + A[n-1]; // Maximum triplet sum
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

    // Function to count the number of triplets with sum ≤ target
    private static int countTriplets(int[] A, int target) {
        int n = A.length;
        int count = 0;

        // Fix first element
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;

            // Two-pointer approach to find valid pairs
            while (left < right) {
                int sum = A[i] + A[left] + A[right];

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

    public static void main(String[] args) {
        int[] A = {3, 1, 4, 1, 5};
        int B = 4;
        System.out.println(findBthSmallestTripletSum(A, B)); // Example Output: 8
    }
}
