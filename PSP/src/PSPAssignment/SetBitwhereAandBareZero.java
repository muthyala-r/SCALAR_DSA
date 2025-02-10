package PSPAssignment;

public class SetBitwhereAandBareZero {

    public static void main(String[] args) {
        int A = 3;
        int B = 5;
        int decimal = solve(A, B);
        System.out.println(decimal);
    }

    public static int solve(int A, int B) {

        int n =0;

        n = (n | (1 << A));

        n = (n | (1 << B));
        return n;
    }
}
