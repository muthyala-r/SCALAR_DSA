package modulararthimatic;

public class ABModuloM {
/*
Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.

 */
    public int solve(int A, int B) {
        int m = A-B;
        return Math.abs(m);
    }
}
