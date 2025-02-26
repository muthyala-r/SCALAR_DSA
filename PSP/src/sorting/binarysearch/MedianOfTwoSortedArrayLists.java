package sorting.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MedianOfTwoSortedArrayLists {
    public static double findMedianSortedArrays(ArrayList<Integer> nums1, ArrayList<Integer> nums2) {
        if (nums1.size() > nums2.size()) {
            return findMedianSortedArrays(nums2, nums1); // Ensure nums1 is smaller
        }

        int x = nums1.size(), y = nums2.size();
        int low = 0, high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1.get(partitionX - 1);
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1.get(partitionX);

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2.get(partitionY - 1);
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2.get(partitionY);

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) { 
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1; // Move partition left
            } else {
                low = partitionX + 1; // Move partition right
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums1 = new ArrayList<>(Arrays.asList(1, 3, 8));
        ArrayList<Integer> nums2 = new ArrayList<>(Arrays.asList(7, 9, 10, 11));
        System.out.println("Median: " + findMedianSortedArrays(nums1, nums2)); // Output: 8.0
    }
}
