package sorting.binarysearch;

public class RotatedArraySearch {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the target
            if (nums[mid] == target) return mid;

            // Check if left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Search left
                } else {
                    left = mid + 1; // Search right
                }
            } 
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // Search right
                } else {
                    right = mid - 1; // Search left
                }
            }
        }
        return -1; // Not found
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println("Index of target: " + search(nums, target)); // Output: 4
    }
}
