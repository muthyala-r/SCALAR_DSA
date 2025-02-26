package hashmapsecondclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountPairSum {

    public static void main(String[] args) {
        /*
        You are given an array A of N integers and an integer B.
        Count the number of pairs (i,j) such that A[i] + A[j] = B and i ≠ j.

Since the answer can be very large, return the remainder after dividing the count with 109+7.

Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once.

A = [3, 5, 1, 2]
B = 8  : output : 1

The only pair is (1, 2) which gives sum 8

A = [1, 2, 1, 2]
B = 3  output ; 4
The pair which gives sum as 3 are (1, 2), (1, 4), (2, 3) and (3, 4).
         */
    }
    public int solve(ArrayList<Integer> A, int B) {

        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        final int mod = (int)(1e9 + 7);
        long ans = 0;
        for(int i = 0 ; i < A.size() ; i++){
            if(freq.containsKey(B - A.get(i))){
                ans = (ans + freq.get(B - A.get(i))) % mod;
            }
            freq.put(A.get(i), freq.getOrDefault(A.get(i), 0) + 1);
        }
        return (int)(ans);
    }

    public int solve1(int[] A, int B) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        final int mod = (int)(1e9 + 7);
        long ans = 0;
        for(int i = 0 ; i < A.length ; i++){
            if(freq.containsKey(B - A[i])){
                ans = (ans + freq.get(B - A[i])) % mod;
            }
            freq.put(A[i], freq.getOrDefault(A[i], 0) + 1);
        }
        return (int)(ans);
    }
}
