package PSPAssignment;

public class NumberOfOneBits {


    public static void main(String[] args) {
        int A = 11; // 1011 output ; 3
        int countOnes  = numSetBits(A);
        System.out.println(countOnes);
    }
    public static int numSetBits(int A) {
        int count  =0 ;
        int n = A;
        while(n != 0){
            n = n &(n-1);
            count++;
        }
        return count;
    }
}
