package hashmapsecondclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumberInWindow {

    public static void main(String[] args) {
/*
You are given an array of N integers, A1, A2 ,..., AN and an integer B.
Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains
number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.

A = [1, 2, 1, 3, 4, 3]
 B = 3
 output ;  [2, 3, 3, 2].
 A=[1, 2, 1, 3, 4, 3] and B = 3
 All windows of size B are
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 So, we return an array [2, 3, 3, 2].

 A = [1, 1, 2, 2]
 B = 1
output : [1, 1, 1, 1]
 Window size is 1, so the output array is [1, 1, 1, 1].


 */
    }

    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        int n = A.size();
        ArrayList<Integer> ret = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // Increase key
            if (m.containsKey(A.get(i))) {
                m.put(A.get(i), m.get(A.get(i)) + 1);
            } else {
                m.put(A.get(i), 1);
            }
            if (i - B + 1 >= 0) {
                // Decrease key
                ret.add(m.size());
                m.put(A.get(i - B + 1), m.get(A.get(i - B + 1)) - 1);
                // Remove if count becomes 0
                if (m.get(A.get(i - B + 1)) == 0) {
                    m.remove(A.get(i - B + 1));
                }
            }
        }
        return ret;
    }
}
