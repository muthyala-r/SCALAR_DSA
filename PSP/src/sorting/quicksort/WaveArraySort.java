package sorting.quicksort;

import java.util.ArrayList;
import java.util.Collections;

public class WaveArraySort {

    public ArrayList<Integer> wave(ArrayList<Integer> A) {

        int n = A.size();
        Collections.sort(A);
        // Swap adjacent elements directly without sorting
        for (int i = 0; i < n - 1; i += 2) {
            // Swap arr[i] and arr[i+1]
            int temp = A.get(i);
            A.set(i, A.get(i + 1));
            A.set(i + 1, temp);
        }

        return A;
    }
}
