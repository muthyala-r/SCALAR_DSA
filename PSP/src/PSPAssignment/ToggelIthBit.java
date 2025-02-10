package PSPAssignment;

public class ToggelIthBit {

    public static void main(String[] args) {
        int A = 29; // 11101 output ; 11001
        int B = 2;
        int togglesecondbit = solve(A, B);
        System.out.println(togglesecondbit);
    }

    public static int solve(int A, int B) {
        int num = A;
        int i = B;

        int mask = (1 << i);

        return num ^ mask;
    }
}
