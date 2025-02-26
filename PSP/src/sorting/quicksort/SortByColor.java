package sorting.quicksort;

import java.util.ArrayList;

public class SortByColor {

    public static void main(String[] args) {
        /*
        Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will represent the colors as,

red -> 0
white -> 1
blue -> 2

Note: Using the library sort function is not allowed.

A = [0, 1, 2, 0, 1, 2]: output : [0, 0, 1, 1, 2, 2]
         */
    }

    public ArrayList<Integer> sortColors(ArrayList<Integer> A) {
        int zero = 0;
        int two = A.size() - 1;

        for (int i = 0; i <= two;) {
            if (A.get(i) == 0) {
                int temp = A.get(zero);
                A.set(zero, 0);
                A.set(i, temp);
                zero++;
                i++;
            } else if (A.get(i) == 2) {
                int temp = A.get(two);
                A.set(two, 2);
                A.set(i, temp);
                two--;
            } else {
                i++;
            }
        }
        return A;

    }
}
