package sorting.binarysearch;

import java.util.*;

public class AggressiveCows {
    public static int largestMinDistance(ArrayList<Integer> A, int B) {
        Collections.sort(A); // Step 1: Sort the stalls
        int low = 1, high = A.get(A.size() - 1) - A.get(0);
        int result = low;

        // Step 2: Binary Search on the maximum minimum distance
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCows(A, B, mid)) { // Check if we can place all cows
                result = mid; // Update the result
                low = mid + 1; // Try for a larger distance
            } else {
                high = mid - 1; // Reduce the distance
            }
        }
        return result;
    }

    // Function to check if we can place B cows with at least `dist` distance
    private static boolean canPlaceCows(ArrayList<Integer> A, int B, int dist) {
        int count = 1; // Place first cow in the first stall
        int lastPos = A.get(0);

        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) - lastPos >= dist) {
                count++;
                lastPos = A.get(i); // Place next cow
                if (count == B) return true; // Successfully placed all cows
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 8, 4, 9));
        int B = 3;
        System.out.println(largestMinDistance(A, B)); // Output: 3
    }
}
