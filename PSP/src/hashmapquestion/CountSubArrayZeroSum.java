package hashmapquestion;

import java.util.ArrayList;
import java.util.HashMap;

public class CountSubArrayZeroSum {

    public static void main(String[] args) {
        /*
        Given an array A of N integers.
Find the count of the subarrays in the array which sums to zero.
Since the answer can be very large,
return the remainder on dividing the result with 10^9+7
A = [1, -1, -2, 2] output: 3
The subarrays with zero sum are [1, -1], [-2, 2] and [1, -1, -2, 2].
 A = [-1, 2, -1]  output: 1
The subarray with zero sum is [-1, 2, -1].

         */
    }
    public int solve(ArrayList<Integer> A) {

        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int count = 0, prefixSum = 0;

        // Initialize map with sum 0 to handle subarrays starting from index 0
        prefixSumMap.put(0, 1);

        for (int num : A) {
            prefixSum += num;

            // If prefix sum was seen before, add its count to result
            count += prefixSumMap.getOrDefault(prefixSum, 0);

            // Update the frequency of prefix sum
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
