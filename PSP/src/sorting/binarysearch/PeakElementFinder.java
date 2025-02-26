package sorting.binarysearch;

import java.util.*;

public class PeakElementFinder {
    public static int findPeakElement(ArrayList<Integer> A) {
        int low = 0, high = A.size() - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (A.get(mid) > A.get(mid + 1)) {
                high = mid; // Peak is in left half (including mid)
            } else {
                low = mid + 1; // Peak is in right half
            }
        }

        return A.get(low); // Peak element found
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 3, 20, 4, 1, 0));
        System.out.println(findPeakElement(A)); // Output: 20
    }
}
