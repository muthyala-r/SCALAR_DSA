package sorting.quicksort;

import java.util.ArrayList;

class PartionIndexSolved {
    public int partition(ArrayList<Integer> arr) {
        int n = arr.size();
        int pivot = arr.get(n - 1); // Last element is the pivot
        int i = -1;  // Initialize pointer for smaller elements

        for (int j = 0; j < n - 1; ++j) {
            // If current element is smaller than pivot
            if (arr.get(j) < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        // Swap pivot element to its correct position
        i++;
        int temp = arr.get(i);
        arr.set(i, pivot);
        arr.set(n - 1, temp);

        return i;  // Return the partition index
    }

    
}
