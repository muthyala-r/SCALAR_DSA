package sorting.binarysearch;

public class StaircaseHeight {
    public static int maxStaircaseHeight(int A) {
        int low = 0, high = A;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sum = (long) mid * (mid + 1) / 2;  // Sum of first `mid` stairs

            if (sum <= A) {
                ans = mid; // Try for a higher stair count
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        /*
        Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max-height using these blocks.

The first stair would require only one block, and the second stair would require two blocks, and so on.

Find and return the maximum height of the staircase.


         */
        int A = 10;
        System.out.println(maxStaircaseHeight(A)); // Output: 4
    }
}
