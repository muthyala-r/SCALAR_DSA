package sorting.binarysearch;

import java.util.Arrays;

public class MaxFrequencyNumber {
    public static int[] maxFrequencyNumber(int[] A, int B) {
        Arrays.sort(A); // Sort the array to make frequency grouping easier
        int n = A.length;
        int left = 0, maxFreq = 0, targetNum = A[0];
        long sum = 0; // To keep track of window sum

        for (int right = 0; right < n; right++) {
            sum += A[right];

            // Check if we can make all elements in window equal to A[right]
            while ((long) A[right] * (right - left + 1) - sum > B) {
                sum -= A[left]; // Remove the leftmost element
                left++; // Shrink window
            }

            // Update max frequency and target number
            int currentFreq = right - left + 1;
            if (currentFreq > maxFreq) {
                maxFreq = currentFreq;
                targetNum = A[right];
            }
        }

        return new int[]{maxFreq, targetNum};
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 4, 4, 5, 2, 6, 2};
        int B = 5;
        int[] result = maxFrequencyNumber(A, B);
        System.out.println("[" + result[0] + ", " + result[1] + "]"); // Example Output: [4, 4]
    }
}
