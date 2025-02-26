package sorting;

import java.util.ArrayList;

public class InversionCount {
    public class Solution {
        private static int mod = 1000 * 1000 * 1000 + 7;
        public static int solve(ArrayList<Integer> A) {
            long inversionCount = mergeSortAndCount(A, 0, A.size() - 1)%mod;
            return (int)inversionCount;
        }
        public static long mergeAndCount(ArrayList<Integer> arr, int left, int mid, int right) {
            int leftSize = mid - left + 1;
            int rightSize = right - mid;

            ArrayList<Integer> leftArr = new ArrayList<>();
            ArrayList<Integer> rightArr = new ArrayList<>();

            for (int i = 0; i < leftSize; i++)
                leftArr.add(arr.get(left + i));
            for (int i = 0; i < rightSize; i++)
                rightArr.add(arr.get(mid + 1 + i));

            int i = 0, j = 0, k = left; long swaps = 0;

            while (i < leftSize && j < rightSize) {
                if (leftArr.get(i) <= rightArr.get(j)) {
                    arr.set(k++, leftArr.get(i++));
                } else {
                    arr.set(k++, rightArr.get(j++));
                    swaps += (mid + 1) - (left + i);
                }
            }

            while (i < leftSize) arr.set(k++, leftArr.get(i++));
            while (j < rightSize) arr.set(k++, rightArr.get(j++));

            return swaps%mod;
        }

        public static long mergeSortAndCount(ArrayList<Integer> arr, int left, int right) {
            long count = 0;
            if (left < right) {
                int mid = left + (right - left) / 2;

                count += mergeSortAndCount(arr, left, mid);
                count += mergeSortAndCount(arr, mid + 1, right);
                count += mergeAndCount(arr, left, mid, right);
            }
            return count%mod;
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(4);
        arr.add(1);
        arr.add(3);
        arr.add(5);
         int mod = 1000 * 1000 * 1000 + 7;
       // long inversionCount = mergeSortAndCount(arr, 0, arr.size() - 1)%mod;
       // System.out.println("Inversion Count: " + inversionCount%mod);
    }
}
