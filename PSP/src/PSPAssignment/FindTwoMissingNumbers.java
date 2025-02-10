package PSPAssignment;

import java.util.ArrayList;
import java.util.List;

public class FindTwoMissingNumbers {

    public static void main(String[] args) {
        List<Integer> A = List.of(2,3,4);
        ArrayList<Integer> nums =  solve(A);
        System.out.println(nums);
    }

    public static  ArrayList<Integer> solve(List<Integer> A) {
        int n = A.size()+2;
        int actualSum = 0;
        int actualSumSquare = 0;

        for(int num : A){
            actualSum += num;
            actualSumSquare += num*num;
        }

        int expectedSum = n * (n+1)/2;
        int expectedSumSquare = n * (n+1) * (2*n +1 ) / 6;

        int sumdiffrence = expectedSum - actualSum;
        int sumSquaredifference = expectedSumSquare - actualSumSquare;

        int product  = (sumdiffrence * sumdiffrence - sumSquaredifference)/2;

        int x = (sumdiffrence +(int)Math.sqrt(sumdiffrence * sumdiffrence - 4 * product))/2;
        int y = sumdiffrence -x;

        ArrayList<Integer> list = new ArrayList();
        list.add(Math.min(x,y));
        list.add(Math.max(x,y));

        return list;

    }

    public int[] solve1(int[] A) {
        int n = A.length;
        int[] ans = new int[2];
        int XOR = 0;
        for(int i = 0; i < n; i++){
            XOR ^= A[i];
        }
        for(int i = 1; i <= n + 2; i++){
            XOR ^= i;
        }
        // XOR has the bitwise XOR of two missing elements. Any set bit
        // in it must be set in one and unset in the other missing number

        // We get the rightmost set bit
        int rightmost_set_bit = XOR & ~(XOR - 1);

        // Divide elements in two sets by comparing rightmost
        // set bit of XOR with bit at same position in each element.
        int x = 0, y = 0;
        for (int i = 0; i < n; i++){
            if((A[i] & rightmost_set_bit) > 0)
                x = x ^ A[i];
            else
                y = y ^ A[i];
        }
        for(int i = 1; i <= n + 2; i++){
            if ((i & rightmost_set_bit) > 0)
                x = x ^ i;
            else
                y = y ^ i;
        }

        ans[0] = Math.min(x, y);
        ans[1] = Math.max(x, y);
        return ans;
    }

}
