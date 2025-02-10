package PSPAssignment;

public class Checkbit {

    public static void main(String[] args) {
        int A = 4;
        int B = 1;
        int BthBit = solve(A, B);
        System.out.println(BthBit);

    }
    public static  int solve(int A, int B) {

        int num = A;
        int i = B;

        int mask = (1 << i);
        return (num & mask) != 0 ? 1 : 0;
    }
}
