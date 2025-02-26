package sorting.binarysearch;

import java.util.*;

public class SingleElementFinder {
    public static int findSingleElement(ArrayList<Integer> A) {
        int low = 0, high = A.size() - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Ensure mid is even for correct pair comparison
            if (mid % 2 == 1) {
                mid--;
            }

            if (A.get(mid).equals(A.get(mid + 1))) {
                low = mid + 2; // Move right
            } else {
                high = mid; // Move left
            }
        }

        return A.get(low); // Single element found
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 3, 3, 4, 4, 7, 8, 8));
        System.out.println(findSingleElement(A)); // Output: 7
    }
}
