package sorting.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class MatrixMedianArrayList {
    public static int findMedian(ArrayList<ArrayList<Integer>> matrix) {
        int rows = matrix.size(), cols = matrix.get(0).size();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        // Find the min and max values in the matrix
        for (ArrayList<Integer> row : matrix) {
            min = Math.min(min, row.get(0));
            max = Math.max(max, row.get(row.size() - 1));
        }

        int desiredCount = (rows * cols) / 2;

        while (min < max) {
            int mid = min + (max - min) / 2;
            int count = 0;

            // Count elements <= mid using binary search
            for (ArrayList<Integer> row : matrix) {
                count += countSmallerEqual(row, mid);
            }

            if (count <= desiredCount) {
                min = mid + 1; // Move right
            } else {
                max = mid; // Move left
            }
        }
        return min;
    }

    // Binary search to count elements <= target in a sorted row
    private static int countSmallerEqual(ArrayList<Integer> row, int target) {
        int low = 0, high = row.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(List.of(1, 3, 5)));
        matrix.add(new ArrayList<>(List.of(2, 6, 9)));
        matrix.add(new ArrayList<>(List.of(3, 6, 9)));

        System.out.println("Median: " + findMedian(matrix)); // Output: 5
    }
}
