package sorting.quicksort;

import java.util.*;

public class QuickSortByFactorsArrayList {

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

    // Quick Sort function for ArrayList
    private static void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition function for Quick Sort
    private static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(high);  // Choose last element as pivot
        int pivotFactors = countFactors(pivot);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            int currentFactors = countFactors(arr.get(j));

            // Sorting criteria:
            // 1. Sort by factor count (ascending)
            // 2. If factors are equal, sort by numeric value (ascending)
            if (currentFactors < pivotFactors || 
                (currentFactors == pivotFactors && arr.get(j) < pivot)) {
                i++;
                // Swap arr[i] and arr[j]
                Collections.swap(arr, i, j);
            }
        }

        // Swap pivot to correct position
        Collections.swap(arr, i + 1, high);

        return i + 1; // Return pivot index
    }

    public static void sortArrayByFactors(List<Integer> numbers) {
        quickSort(numbers, 0, numbers.size() - 1);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 5, 20, 9, 16));

        sortArrayByFactors(numbers);

        // Print sorted list
        System.out.println(numbers);
    }
}
