package psp;

import java.util.Arrays;

public class maximusubarrayWithlengthN {
   // A = [4, 3, 2, 6, 1]
   // B = 3
    // C = 11
    public int solve(int[] A, int B, int C) {
        int sum = 0;
        for(int i = 0 ; i < A.length ; i++){
            sum += A[i];
            if(i >= B){
                sum -= A[i - B];
            }
            if(sum == C && i >= B - 1){
                return 1;
            }
        }
        return 0;
    }

//sliding window
    public static void findMaxSubArrayWithLength(int[] arr, int n) {
        if (arr.length < n) {
            System.out.println("Invalid input: Array length is smaller than subarray length.");
            return;
        }

        int maxSum = 0;
        int currentSum = 0;
        int startIndex = 0;

        // Calculate sum of the first window
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
        }
        maxSum = currentSum;

        // Slide the window from start to the end of the array
        for (int i = n; i < arr.length; i++) {
            currentSum = currentSum - arr[i - n] + arr[i];  // Slide the window
            if (currentSum > maxSum) {
                maxSum = currentSum;
                startIndex = i - n + 1;  // Update start index of maximum subarray
            }
        }

        // Print the maximum sum and subarray
        System.out.println("Maximum sum of subarray with length " + n + " is: " + maxSum);
        System.out.println("Maximum subarray is: " + Arrays.toString(Arrays.copyOfRange(arr, startIndex, startIndex + n)));
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int length = 3;
        findMaxSubArrayWithLength(array, length);
    }


}
