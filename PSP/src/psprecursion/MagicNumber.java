package psprecursion;

public class MagicNumber {

    public int solve(int A) {

        if (A < 10) {
            return (A == 1) ? 1 : 0;
        }
        int digit_sum = 0;
        while (A > 0) {
            digit_sum += A % 10;
            A /= 10;
        }
        return solve(digit_sum);

    }
}
