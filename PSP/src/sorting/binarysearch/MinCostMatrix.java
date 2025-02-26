package sorting.binarysearch;

import java.util.*;

public class MinCostMatrix {
    public static boolean isValid(ArrayList<ArrayList<Integer>> C, int A, int B, int minDiff) {
        // DP approach to check if we can form a valid sequence with minDiff
        ArrayList<Integer> prevRow = C.get(0);

        for (int i = 1; i < A; i++) {
            ArrayList<Integer> currRow = C.get(i);
            boolean valid = false;

            for (int x : prevRow) {
                for (int y : currRow) {
                    if (Math.abs(x - y) >= minDiff) {
                        valid = true;
                        break;
                    }
                }
                if (valid) break;
            }

            if (!valid) return false;
            prevRow = currRow;
        }
        return true;
    }

    public static int minimizeCost(ArrayList<ArrayList<Integer>> C) {
        int A = C.size();
        int B = C.get(0).size();

        // Sort each row to allow efficient selection
        for (ArrayList<Integer> row : C) {
            Collections.sort(row);
        }

        // Binary search on cost
        int low = 0, high = 1000000000; // High is a large value based on input constraints
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(C, A, B, mid)) {
                ans = mid;  // If valid, try for a larger minimum difference
                low = mid + 1;
            } else {
                high = mid - 1;  // Otherwise, reduce the range
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        /*
        You are given a 2-D matrix C of size A × B.
You need to build a new 1-D array of size A by taking one element from each row of the 2-D matrix in such a way that the cost of the newly built array is minimized.

The cost of an array is the minimum possible value of the absolute difference between any two adjacent elements of the array.

So if the newly built array is X, the element picked from row 1 will become X[1], element picked from row 2 will become X[2], and so on.

Determine the minimum cost of the newly built array
         */

        ArrayList<ArrayList<Integer>> C = new ArrayList<>();
        C.add(new ArrayList<>(Arrays.asList(1, 3, 5)));
        C.add(new ArrayList<>(Arrays.asList(4, 8, 10)));
        C.add(new ArrayList<>(Arrays.asList(6, 9, 15)));

        System.out.println(minimizeCost(C));  // Output: Minimum cost of the 1D array
    }
}
