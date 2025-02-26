package hashmapsecondclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumZero {

    public static void main(String[] args) {
        /*
Given an array A of N integers.
Find the length of the longest subarray in the array which sums to zero.
If there is no subarray which sums to zero then return 0.

A = [1, -2, 1, 2]  output : 3
 [1, -2, 1] is the largest subarray which sums up to 0.

 A = [3, 2, -1] output : 0  No subarray sums up to 0.
         */
    }

    public int solve(ArrayList<Integer> A) {

        Map<Integer,Integer> prefixMap = new HashMap();
        int maxLength = 0, prefixSum =0;

        for(int i = 0 ; i < A.size(); i++){

            prefixSum += A.get(i);

            if(prefixSum == 0){
                maxLength = i+1;
            }

            if(prefixMap.containsKey(prefixSum)){
                maxLength = Math.max(maxLength, i - prefixMap.get(prefixSum));
            }else{
                prefixMap.put(prefixSum, i);
            }
        }

        return maxLength;
    }

    public int solve1(ArrayList<Integer> A) {
        HashMap<Long, Integer> pref = new HashMap<Long, Integer>();
        Long curr = 0L;
        int ans = 0;
        pref.put(0L, 0);
        for(int i = 1 ; i <= A.size() ; i++){
            curr += A.get(i-1);
            if(pref.containsKey(curr)){
                ans = Math.max(ans, i - pref.get(curr));
            }
            else{
                pref.put(curr, i);
            }
        }
        return ans;


    }
}
