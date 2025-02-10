package PSPAssignment;

public class UnsetIthBit {

    public static void main(String[] args) {
        int A =  29;   // 11101  output ; 10101
         int B = 3;
         int thirdunset = solve(A, B);
        System.out.println(thirdunset);
    }

    public static int solve(int A, int B) {
        //create a mask with the i th bit as 0 and other as 1

        int num = A;
        int i = B;
        int mask = ~(1 <<i);

        return num & mask;
    }
}
