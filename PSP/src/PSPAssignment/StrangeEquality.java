package PSPAssignment;

public class StrangeEquality {

    public int solve(int A) {
        int bit = 0, x = 0;
        // x is equal to the summation of unset bits in A
        while (A != 0) {
            if (A % 2 == 0) {
                x = x | (1 << bit);
            }
            A /= 2;
            bit++;
        }
        // y equals the power of 2 just greater than A
        int y = (1 << bit);
        return x ^ y;
    }
}
