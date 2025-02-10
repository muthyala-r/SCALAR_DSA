package PSPAssignment;

import java.util.ArrayList;

public class MergeSortedOvarlappingIntervals {

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        // res is the ArrayList that we will return
        ArrayList<ArrayList<Integer>> res;

        ArrayList<Integer> interval;
        int n = A.size();
        res = new ArrayList<>();

        for (int i = 0; i < n;) {
            // making a new segment
            interval = new ArrayList<>(A.get(i));
            ArrayList<Integer> next;
            i++;
            while (i < n) {
                next = A.get(i);
                // Checking if i-th element falls in the current segment
                if (overlap(interval, next)) {
                    // adding i-th element to the current segment
                    interval.set(1, Math.max(interval.get(1), next.get(1)));
                    i++;
                } else {
                    break;
                }
            }
            // adding current segment to our answer.
            res.add(interval);
        }
        return res;
    }

    private boolean overlap(ArrayList<Integer> int1, ArrayList<Integer> int2) {
        if (int1.get(1) >= int2.get(0) && int1.get(0) <= int2.get(1))
            return true;
        return false;
    }

}
