package sorting.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class RotatedSortedArrayListSearch {
    public static int search(ArrayList<Integer> nums, int target) {
        int left = 0, right = nums.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Found the target
            if (nums.get(mid) == target) return mid;

            // Check which half is sorted
            if (nums.get(left) <= nums.get(mid)) { // Left half is sorted
                if (target >= nums.get(left) && target < nums.get(mid)) {
                    right = mid - 1; // Search in left half
                } else {
                    left = mid + 1; // Search in right half
                }
            } else { // Right half is sorted
                if (target > nums.get(mid) && target <= nums.get(right)) {
                    left = mid + 1; // Search in right half
                } else {
                    right = mid - 1; // Search in left half
                }
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 0, 1, 2));
        int target = 0;
        System.out.println("Index of target: " + search(nums, target)); // Output: 4
    }
}
