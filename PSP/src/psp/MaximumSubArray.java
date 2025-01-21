package psp;

import java.util.ArrayList;
import java.util.HashMap;

public class MaximumSubArray {

    public static void main(String[] args) {

        int A = 5;
        int B = 12;
        ArrayList<Integer> C = new ArrayList();
        C.add(2);
        C.add(1);
        C.add(3);
        C.add(4);
        C.add(5);
       int ans = maxSubarray(A,B,C);

        System.out.println(ans);

    }
    public static int maxSubarray(int A, int B, ArrayList<Integer> C) {


            int ans = 0;
            for (int i = 0; i < A; i++) {
                int sum = 0;
                for (int j = i; j < A; j++) {
                    sum += C.get(j);
                    if (sum <= B)
                        ans = Math.max(ans, sum);
                    else break;
                }
            }
            return ans;
        }



}
