package sorting;

import java.util.ArrayList;
import java.util.Collections;

public class SortSubArray {
    public static void sortSubArray(ArrayList<Integer> arr, int left, int right) {
        if (left < 0 || right >= arr.size() || left > right) {
            throw new IllegalArgumentException("Invalid left or right index");
        }

        // Step 1: Extract subarray and sort it
        Collections.sort(arr.subList(left, right + 1));
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(5);
        arr.add(3);
        arr.add(8);
        arr.add(15);
        arr.add(6);

        int left = 1, right = 4;  // Sorting index range [1, 4]
        
        System.out.println("Original ArrayList: " + arr);
        sortSubArray(arr, left, right);
        System.out.println("After Sorting Subarray [" + left + ", " + right + "]: " + arr);
    }
}
