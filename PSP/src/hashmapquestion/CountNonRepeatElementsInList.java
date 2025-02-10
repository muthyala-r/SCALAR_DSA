package hashmapquestion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CountNonRepeatElementsInList {
    public static void main(String[] args) {
        /*
        You are given an array A of N integers. Return the count of elements with frequncy 1 in the given array.
        A = [3, 3, 3, 9, 0, 1, 0] output : 2  non-repeats are 9,1
         */
    }
    public int solve(ArrayList<Integer> A) {

        Set<Integer> unique = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();

        for (int num : A) {
            if (!unique.add(num)) {
                duplicate.add(num);
            }
        }
        unique.removeAll(duplicate);


        return unique.size();

    }
}
