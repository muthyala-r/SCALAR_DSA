package hashmapsecondclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualtoK {

    public static void main(String[] args) {
      /*
      Given an array of integers A and an integer B.
      Find the total number of subarrays having sum equals to B.

      The first argument given is the integer array A.
       The second argument given is integer B.

        A = [1, 0, 1]
        B = 1

        output : 4
        [1], [1, 0], [0, 1] and [1] are four subarrays having sum 1.

       */

    }

    public int solve(ArrayList<Integer> A, int B) {

        Map<Integer,Integer> prefixsumMap = new HashMap();

        prefixsumMap.put(0,1);

        int count  = 0;
        int prefixSum = 0;

        for(int num: A){

            prefixSum += num;

            if(prefixsumMap.containsKey(prefixSum-B)){
                count += prefixsumMap.get(prefixSum -B);
            }

            prefixsumMap.put(prefixSum, prefixsumMap.getOrDefault(prefixSum,0)+1);
        }

        return count;
    }
}
