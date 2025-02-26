package sorting.quicksort;

import java.util.ArrayList;

public class LargestNumberWithGiventIntegers {
    public String largestNumber(ArrayList<Integer> A) {

        String[] strNums = new String[A.size()];
        for (int i = 0; i < A.size(); i++) {
            strNums[i] = String.valueOf(A.get(i));
        }

        // Apply QuickSort
        quickSort(strNums, 0, strNums.length - 1);

        // Edge case: If the largest number is "0", return "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Build the final result
        StringBuilder result = new StringBuilder();
        for (String num : strNums) {
            result.append(num);
        }

        return result.toString();
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Partition function for QuickSort
    private static int partition(String[] arr, int low, int high) {
        String pivot = arr[high]; // Choose the last element as pivot
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            // Compare based on concatenation order
            if ((arr[j] + pivot).compareTo(pivot + arr[j]) > 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high); // Place pivot at the correct position
        return i + 1;
    }

    // QuickSort implementation
    private static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // Partitioning index
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
