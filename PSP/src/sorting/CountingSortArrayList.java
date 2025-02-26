package sorting;

import java.util.ArrayList;
import java.util.Collections;

public class CountingSortArrayList {
    public static void countingSort(ArrayList<Integer> A) {
        if (A.isEmpty()) return;

        // Step 1: Find the maximum element
        int max = Collections.max(A);

        // Step 2: Create frequency array
        int[] count = new int[max + 1];

        for (int num : A) {
            count[num]++;
        }

        // Step 3: Reconstruct sorted array
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                A.set(index++, i);
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(2);
        arr.add(2);
        arr.add(8);
        arr.add(3);
        arr.add(3);
        arr.add(1);

        System.out.println("Original ArrayList: " + arr);
        countingSort(arr);
        System.out.println("Sorted ArrayList: " + arr);
    }
}
