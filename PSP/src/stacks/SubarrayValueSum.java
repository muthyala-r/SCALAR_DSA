package stacks;

import java.util.*;

public class SubarrayValueSum {
    static final int MOD = 1000000007;

    public static int sumOfSubarrayValues(int[] A) {
        int n = A.length;
        long sum = 0;

        int[] leftMax = new int[n], rightMax = new int[n];
        int[] leftMin = new int[n], rightMin = new int[n];

        Arrays.fill(leftMax, -1);
        Arrays.fill(rightMax, n);
        Arrays.fill(leftMin, -1);
        Arrays.fill(rightMin, n);

        // Monotonic Stack for Finding Left & Right Boundaries for Max Elements
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                rightMax[stack.pop()] = i;
            }
            leftMax[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }

        // Monotonic Stack for Finding Left & Right Boundaries for Min Elements
        stack.clear();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                rightMin[stack.pop()] = i;
            }
            leftMin[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }

        // Compute Final Sum Using Contribution Approach
        for (int i = 0; i < n; i++) {
            long maxContribution = (long) (i - leftMax[i]) * (rightMax[i] - i) % MOD * A[i] % MOD;
            long minContribution = (long) (i - leftMin[i]) * (rightMin[i] - i) % MOD * A[i] % MOD;
            sum = (sum + maxContribution - minContribution + MOD) % MOD;
        }

        return (int) sum;
    }

    public static void main(String[] args) {
        int[] A1 = {1};
        System.out.println(sumOfSubarrayValues(A1)); // Output: 0

        int[] A2 = {4, 7, 3, 8};
        System.out.println(sumOfSubarrayValues(A2)); // Output: 26
    }
}
