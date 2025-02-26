package sorting;

import java.util.ArrayList;

public class MergeSort {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        mergeSort(A, 0 , A.size());

        return A;
    }

    public static void mergeSort(ArrayList<Integer> list, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Avoids overflow

            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);

            merge(list, left, mid, right);
        }
    }

    // Merge two sorted halves
    public static void merge(ArrayList<Integer> list, int left, int mid, int right) {
        int n1 = mid - left + 1;  // Size of left sublist
        int n2 = right - mid;     // Size of right sublist

        // Create temporary lists
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        // Copy data to temp lists manually
        for (int i = 0; i < n1; i++) {
            leftList.add(list.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightList.add(list.get(mid + 1 + j));
        }

        // Merge the temp lists back into the original list
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftList.get(i) <= rightList.get(j)) {
                list.set(k, leftList.get(i));
                i++;
            } else {
                list.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftList[], if any
        while (i < n1) {
            list.set(k, leftList.get(i));
            i++;
            k++;
        }

        // Copy remaining elements of rightList[], if any
        while (j < n2) {
            list.set(k, rightList.get(j));
            j++;
            k++;
        }
    }
/*
approach 2
 */
    public ArrayList<Integer> solve1(ArrayList<Integer> A) {

        ArrayList<Integer> resultList = mergeSort(A);

        return resultList;
    }

    // Merge Sort function (Recursive)
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
        if (list.size() <= 1) {
            return list; // Base case: Single element is already sorted
        }

        int mid = list.size() / 2;

        // Manually split the list into left and right halves
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            leftList.add(list.get(i));
        }
        for (int i = mid; i < list.size(); i++) {
            rightList.add(list.get(i));
        }

        // Recursively sort both halves
        leftList = mergeSort(leftList);
        rightList = mergeSort(rightList);

        // Merge the sorted halves
        return merge(leftList, rightList);
    }

    // Merge two sorted lists
    public static ArrayList<Integer> merge(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        // Merge elements in sorted order
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i) <= rightList.get(j)) {
                mergedList.add(leftList.get(i));
                i++;
            } else {
                mergedList.add(rightList.get(j));
                j++;
            }
        }

        // Add remaining elements from leftList, if any
        while (i < leftList.size()) {
            mergedList.add(leftList.get(i));
            i++;
        }

        // Add remaining elements from rightList, if any
        while (j < rightList.size()) {
            mergedList.add(rightList.get(j));
            j++;
        }

        return mergedList;
    }
}
