package psp;

import java.util.ArrayList;

public class PicFromBothSides {

    public class Solution {
        public int solve(ArrayList<Integer> A, int B) {

            int n = A.size();

            int currentSum =0 ;

            for(int i =0 ; i< B; i++){
                currentSum += A.get(i);
            }

            int maxSum =currentSum;

            for (int i =0; i< B;i++){
                currentSum = currentSum - A.get(B-1-i)+A.get(n-1-i);
                maxSum = Math.max(maxSum,currentSum);
            }

            return maxSum;
        }
    }

}
