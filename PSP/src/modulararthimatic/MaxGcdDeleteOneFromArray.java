package modulararthimatic;

import java.util.ArrayList;

public class MaxGcdDeleteOneFromArray {

    /*
    Given an integer array A of size N.
    You have to delete one element such that the GCD(Greatest common divisor)
     of the remaining array is maximum.

     A = [12, 15, 18]  ouput:  6
     If you delete 12, gcd will be 3.
    If you delete 15, gcd will be 6.
    If you delete 18, gcd will 3.
    Maximum value of gcd is 6.

     */
    public int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    public int[]suffixGCD(int[] A){
        int n = A.length;
        int[] suf = new int[n];
        int g = 0;
        for (int i = n - 1; i >= 0; i--) {
            g = gcd(g, A[i]);
            suf[i] = g;
        }
        return suf;
    }
    public int solve(int[] A) {
        int n = A.length, ans = 1;
        // suf stores the suffix gcd of the array
        int[] suf = suffixGCD(A);
        int curGcd = 0;
        for (int i = 0; i < n; i++) {
            if (i != n - 1)
                ans = Math.max(ans, gcd(suf[i + 1], curGcd));
            else
                ans = Math.max(ans, curGcd);
            curGcd = gcd(curGcd, A[i]);
        }
        return ans;
    }

    public int solve(ArrayList<Integer> A) {

        int n = A.size(), ans = 1;
        // suf stores the suffix gcd of the array
        int[] suf = suffixGCD1(A);
        int curGcd = 0;
        for (int i = 0; i < n; i++) {
            if (i != n - 1)
                ans = Math.max(ans, gcd(suf[i + 1], curGcd));
            else
                ans = Math.max(ans, curGcd);
            curGcd = gcd(curGcd, A.get(i));
        }
        return ans;
    }



    public int gcd1(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    public int[]suffixGCD1(ArrayList<Integer> A){
        int n = A.size();
        int[] suf = new int[n];
        int g = 0;
        for (int i = n - 1; i >= 0; i--) {
            g = gcd(g, A.get(i));
            suf[i] = g;
        }
        return suf;
    }
}
