package sorting;

    public class SortSubArrayWithLeftAndRightIndex {
    public void merge(int[] sorted, int left, int mid, int right) {
        int m1 = mid - left + 1, m2 = right - mid;

        int[] arr1 = new int[m1];
        int[] arr2 = new int[m2];

        for (int i = 0; i < m1; ++i) {
            arr1[i] = sorted[left + i];
        }

        for (int j = 0; j < m2; ++j) {
            arr2[j] = sorted[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < m1 && j < m2) {
            if (arr1[i] <= arr2[j]) {
                sorted[k++] = arr1[i++];
            } else {
                sorted[k++] = arr2[j++];
            }
        }

        while (i < m1) {
            sorted[k++] = arr1[i++];
        }

        while (j < m2) {
            sorted[k++] = arr2[j++];
        }
    }

    public void mergeSort(int[] A, int L, int R) {
        if (L < R) {
            int M = (L + R) / 2;

            // divide
            mergeSort(A, L, M);
            mergeSort(A, M + 1, R);

            // conquer
            merge(A, L, M, R);
        }
    }

    public int[] sortSubarray(int[] A, int B, int C) {
        mergeSort(A, B, C);
        return A;
    }
}