package sorting.binarysearch;

import java.util.*;

public class PaintersPartition {
    static int MOD = 10000003;

    public static int minTimeToPaintBoards(int A, int B, ArrayList<Integer> C) {
        long low = Collections.max(C) * (long) B; // Min time = Largest board * B
        long high = sum(C) * (long) B; // Max time = Sum of all boards * B
        long result = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            // Check if we can paint all boards within mid time using <= A painters
            if (canPaint(C, A, mid / B)) { // mid / B gives max allowed board length per painter
                result = mid % MOD;
                high = mid - 1; // Try for a smaller time
            } else {
                low = mid + 1; // Increase time limit
            }
        }

        return (int) result;
    }

    // Check if we can paint all boards using at most A painters with maxTime per painter
    private static boolean canPaint(ArrayList<Integer> C, int A, long maxTime) {
        int painters = 1;
        long currentSum = 0;

        for (int board : C) {
            if (currentSum + board > maxTime) {
                painters++;
                currentSum = board;
                if (painters > A) return false;
            } else {
                currentSum += board;
            }
        }
        return true;
    }

    // Function to calculate sum of elements in ArrayList
    private static long sum(ArrayList<Integer> C) {
        long sum = 0;
        for (int num : C) sum += num;
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(1, 10)); 
        int A = 2, B = 5;
        System.out.println(minTimeToPaintBoards(A, B, C)); // Output: 50
    }
}
