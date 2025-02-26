package sorting.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxFrequencyNumberArrayList {
    public static ArrayList<Integer> maxFrequencyNumber(ArrayList<Integer> A, int B) {
        Collections.sort(A); // Sort the array for grouping
        int n = A.size();
        int left = 0, maxFreq = 0, targetNum = A.get(0);
        long sum = 0; // Window sum

        for (int right = 0; right < n; right++) {
            sum += A.get(right);

            // Check if we can make all elements in the window equal to A[right]
            while ((long) A.get(right) * (right - left + 1) - sum > B) {
                sum -= A.get(left);
                left++; // Shrink the window
            }

            // Update max frequency and target number
            int currentFreq = right - left + 1;
            if (currentFreq > maxFreq) {
                maxFreq = currentFreq;
                targetNum = A.get(right);
            }
        }

        return new ArrayList<>(List.of(maxFreq, targetNum));
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(3, 1, 4, 4, 5, 2, 6, 2));
        int B = 5;
        ArrayList<Integer> result = maxFrequencyNumber(A, B);
        System.out.println(result); // Example Output: [4, 4]
    }
}
