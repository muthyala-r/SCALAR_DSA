package modulararthimatic;

import java.util.ArrayList;

public class ModSum {
/*
Given an array of integers A, calculate the sum of A [ i ] % A [ j ]
for all possible i, j pairs. Return sum % (10^9 + 7) as an output.
 */
    public int solve(ArrayList<Integer> A) {
        int n = A.size(), mod = 1000 * 1000 * 1000 + 7;

        // To store the frequency of each element
        int[] cnt = new int[1009];

        // Store the frequency of each element
        for(int a: A)
            cnt[a]++;

        // To store the required answer
        int ans = 0;

        // For all valid pairs
        for(int i = 1; i <= 1000; i++){
            if(cnt[i] == 0)
                continue;
            for(int j = 1; j <= 1000; j++){
                if(cnt[j] == 0)
                    continue;
                // Update the count
                int val = j % i;
                int temp = cnt[i] * cnt[j] * val;
                ans = ((ans % mod) + (temp % mod)) % mod;
            }
        }
        return ans;

    }
}
