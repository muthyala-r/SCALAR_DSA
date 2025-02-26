package sorting.binarysearch;

import java.math.BigInteger;

public class AthMagicalNumber {
    private static final int MOD = 1_000_000_007;

    public static int findAthMagicalNumber(int A, int B, int C) {
        long low = 1, high = (long) 2e18; // High is a large number to avoid overflow
        long lcm = lcm(B, C); // Calculate LCM of B and C

        while (low < high) {
            long mid = low + (high - low) / 2;
            long count = (mid / B) + (mid / C) - (mid / lcm);

            if (count < A) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return (int) (low % MOD);
    }

    // Function to calculate LCM using GCD
    private static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    // Function to calculate GCD using Euclidean algorithm
    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int A = 4, B = 2, C = 3;
        System.out.println(findAthMagicalNumber(A, B, C)); // Output: 6
    }
}
