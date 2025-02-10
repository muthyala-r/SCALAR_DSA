package psprecursion;

public class SumOfDigits {

    public int solve(int A) {

        int sum  = 0 ;

        while(A>0){
            int r  = A%10;
            sum += r;

            A /= 10;
        }

        return sum;
    }
}
