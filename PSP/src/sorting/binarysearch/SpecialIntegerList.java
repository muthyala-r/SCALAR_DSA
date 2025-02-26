package sorting.binarysearch;

import java.util.ArrayList;

public class SpecialIntegerList {

    public int solve(ArrayList<Integer> A, int B) {
        ArrayList<Long> prefix = new  ArrayList<Long>(A.size());
        prefix_function(A, prefix);
        // Binary search for the length
        int lo = 1;
        int hi = A.size(), ans = 0;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo; // to keep our mid towards the right
            if (check(mid, prefix, (long) B) == 1) {
                hi = mid - 1;
            } else {
                ans = mid;
                lo = mid + 1;
            }
        }
        return ans;
    }

    public void prefix_function(ArrayList<Integer> A, ArrayList<Long>  prefix){
        // calculating the prefix sum
        for (int i = 0; i < A.size(); ++i) {
            prefix.add((long)A.get(i));
            if(i > 0)
                prefix.set(i, prefix.get(i) + prefix.get(i - 1));
        }
    }

    int check(int s, ArrayList<Long> arr, long sm) {
        int flag = 0;
        for (int i = s - 1; i < arr.size(); ++i) {
            if (i == s - 1) {
                if (arr.get(i) > sm)
                    return 1;
            } else if (arr.get(i) - arr.get(i-s) > sm) {
                return 1;
            }
        }
        return 0;
    }

}
