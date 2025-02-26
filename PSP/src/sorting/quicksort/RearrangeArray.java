package sorting.quicksort;

public class RearrangeArray {

    // Partition function to rearrange the array based on pivot (last element)
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Choosing the last element as pivot
        int i = low - 1;  // Index for smaller elements

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) { // If current element is smaller than pivot
                i++;
                swap(arr, i, j);  // Swap arr[i] and arr[j]
            }
        }

        // Swap pivot element to its correct position
        swap(arr, i + 1, high);
        return i + 1;  // Return the partition index
    }

    // Swap method to exchange elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to rearrange the array based on pivot
    public static void rearrangeArray(int[] arr) {
        int n = arr.length;
        partition(arr, 0, n - 1);  // Call partition with low = 0 and high = last index
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        rearrangeArray(arr);

        // Print the rearranged array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
