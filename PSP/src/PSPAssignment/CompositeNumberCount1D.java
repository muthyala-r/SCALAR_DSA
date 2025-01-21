package PSPAssignment;

import java.util.*;

public class CompositeNumberCount1D {

    // Helper function to check if a number is composite
    public static boolean isComposite(int num) {
        if (num <= 1) return false; // 0 and 1 are neither prime nor composite
        if (num <= 3) return false; // 2 and 3 are prime
        if (num % 2 == 0 || num % 3 == 0) return true; // multiples of 2 or 3 are composite
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return true;
            }
        }
        return false;
    }

    // Function to count composite numbers for each range query
    public static List<Integer> compositeNumberCount(int[] arr, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int compositeCount = 0;
            for (int i = l; i <= r; i++) {
                if (isComposite(arr[i])) {
                    compositeCount++;
                }
            }
            result.add(compositeCount);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 9, 12, 17, 15, 10, 5};
        int[][] queries = {
            {1, 3},  // Subarray: {4, 6, 8} -> Composite: 4, 6, 8 -> Count: 3
            {4, 7},  // Subarray: {9, 12, 17, 15} -> Composite: 9, 12, 15 -> Count: 3
            {0, 9}   // Entire array -> Count: 7
        };

        List<Integer> result = compositeNumberCount(arr, queries);
        System.out.println("Composite numbers count for each query: " + result);  // Output: [3, 3, 7]
    }
}
