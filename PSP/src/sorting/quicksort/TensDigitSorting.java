package sorting.quicksort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TensDigitSorting {

    public static void main(String[] args) {
        /*
        Given an array A of N integers. Sort the array in increasing order of the value at the tens place digit of every number.

If a number has no tens digit, we can assume value to be 0.
If 2 numbers have same tens digit, in that case number with max value will come first
Solution should be based on comparator.

A = [15, 11, 7, 19] output: [7, 19, 15, 11]

         */
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // Extract tens digit
                int tensA = (a / 10) % 10;
                int tensB = (b / 10) % 10;

                // First, sort by tens digit (ascending)
                if (tensA != tensB) {
                    return Integer.compare(tensA, tensB);
                }

                // If tens digits are same, sort by value (descending)
                return Integer.compare(b, a);
            }
        });

        return A;
    }
}
