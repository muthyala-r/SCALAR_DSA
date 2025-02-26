package sorting.quicksort;

import java.util.*;

public class SortByFactors {

    // Function to count the number of divisors of a number
    private static int countFactors(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                count++; // i is a factor
                if (i != num / i) {
                    count++; // num/i is also a factor (avoid duplicate counting)
                }
            }
        }
        return count;
    }

    // Quick Sort implementation
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition function for Quick Sort
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose last element as pivot
        int pivotFactors = countFactors(pivot);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            int currentFactors = countFactors(arr[j]);

            // Sorting criteria:
            // 1. Sort by factor count (ascending)
            // 2. If factors are equal, sort by numeric value (ascending)
            if (currentFactors < pivotFactors || 
                (currentFactors == pivotFactors && arr[j] < pivot)) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot to correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return pivot index
    }

    // Function to sort array based on the given criteria
    public static void sortArrayByFactors(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 9, 16};
        sortArrayByFactors(arr);

        // Print sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
