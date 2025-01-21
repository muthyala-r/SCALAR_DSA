package PSPAssignment;

public class KadansAlgorithm {
    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubArraySum(array);
        System.out.println("Maximum subarray sum is: " + maxSum);

    }

    private static int maxSubArraySum(int[] array) {
        int currentSum = array[0];
        int maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
            currentSum = Math.max(array[i], currentSum+array[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }


}
