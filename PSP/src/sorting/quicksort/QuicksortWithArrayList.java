package sorting.quicksort;

import java.util.ArrayList;

public class QuicksortWithArrayList {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {

            quickSort(A, 0 , A.size()-1);
            return A;
    }

    public  void quickSort(ArrayList<Integer> A, int low, int high) {
            if (low < high) {
                int pivot = partition(A, low, high);
                quickSort(A, low, pivot - 1);
                quickSort(A, pivot + 1, high);
            }
        }

        private  int partition(ArrayList<Integer> A, int low, int high) {
            int pivot = A.get(high);
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (A.get(j) < pivot) {
                    i++;
                    swap(A, i, j);
                }
            }
            swap(A, i + 1, high);
            return i + 1;
        }

        private  void swap(ArrayList<Integer> A, int i, int j) {
            int temp = A.get(i);
            A.set(i,A.get(j));
            A.set(j,temp); 
        }

}
