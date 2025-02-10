package hashmapquestion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SubArraySumisZero {

    public static void main(String[] args) {
        /*
        A = [1, 2, 3, 4, 5] , return 0;
        A = [4, -1, 1] , return 1; -1+1= 0 , -1,1 is one subarray
         */
    }
    public int solve(ArrayList<Integer> A) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.

        Set<Integer> prefixsumSet = new HashSet();
        int prefixSum = 0;

        for(int num: A){
            prefixSum += num ;

            if(prefixSum == 0 || prefixsumSet.contains(prefixSum)){
                return 1;
            }

            prefixsumSet.add(prefixSum);
        }
        return 0;
    }



    public int solve1(ArrayList < Integer > A) {
        HashSet < Long > set = new HashSet < Long > ();
        long sum = 0;
        set.add(sum);
        for (int x: A) {
            sum += x;
            if (set.contains(sum)) return 1;
            else {
                set.add(sum);
            }
        }
        return 0;
    }

}
