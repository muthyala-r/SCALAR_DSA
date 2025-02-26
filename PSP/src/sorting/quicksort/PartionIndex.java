package sorting.quicksort;

public class PartionIndex {

    public int partition(int[] arr) {
        int n = arr.length;
        int pivotVal = arr[n - 1];
        int i = 0;

        for (int j = 0; j < n; ++j) {
            if (arr[j] < pivotVal) {
                // move smaller values to the left end
                // expand region 1
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                ++i;
            }
        }

        // moving pivot to the partition index
        int temp = arr[i];
        arr[i] = arr[n - 1];
        arr[n - 1] = temp;

        return i;
    }

}
