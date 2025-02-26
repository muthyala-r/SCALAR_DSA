package sorting.binarysearch;

import java.util.*;

public class BinarySearchLeastGreterThanB {


    public static int findIndex(ArrayList<Integer> A, int B) {
        int low = 0, high = A.size() - 1;
        int ans = A.size();  // Default position if no element >= B

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A.get(mid) == B) {
                return mid; // Target found
            } else if (A.get(mid) < B) {
                low = mid + 1; // Move right
            } else {
                ans = mid;  // Store possible position
                high = mid - 1; // Move left
            }
        }
        return ans;  // Return the correct position
    }

    public static void main(String[] args) {

        /*
        If the target value is present, return its index.
If the target value is not found, return the index of least element greater than equal to B.
If the target value is not found and least number greater than equal to target is also not present, return the length of array (i.e. the position where target can be placed)
Your solution should have a time complexity of O(log(N)).
         */
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 3, 5, 6, 8, 10, 15));
        int B1 = 5;  // Present in the list
        int B2 = 7;  // Not present, should return index of least element >= 7
        int B3 = 20; // Greater than all elements, should return size of the array

        System.out.println(findIndex(A, B1)); // Output: 2
        System.out.println(findIndex(A, B2)); // Output: 4
        System.out.println(findIndex(A, B3)); // Output: 7 (A.size())
    }
}
