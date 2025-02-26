package sorting.binarysearch;

import java.util.*;

public class MatrixMedian {
    public static int findMedian(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        // Find the min and max values in the matrix
        for (int i = 0; i < rows; i++) {
            min = Math.min(min, matrix[i][0]);
            max = Math.max(max, matrix[i][cols - 1]);
        }

        int desiredCount = (rows * cols) / 2;

        while (min < max) {
            int mid = min + (max - min) / 2;
            int count = 0;

            // Count elements <= mid using binary search
            for (int i = 0; i < rows; i++) {
                count += countSmallerEqual(matrix[i], mid);
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
    private static int countSmallerEqual(int[] row, int target) {
        int low = 0, high = row.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5},
            {2, 6, 9},
            {3, 6, 9}
        };
        System.out.println("Median: " + findMedian(matrix)); // Output: 5
    }
}
