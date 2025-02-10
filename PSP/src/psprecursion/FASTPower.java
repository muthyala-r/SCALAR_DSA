package psprecursion;

public class FASTPower {

    public static void main(String[] args) {
        int A = 2 , B = 3;
        Long result = power(A, B);
        System.out.println(result);
    }
    public static Long power(int A, int B) {

        if(B == 0){
            return 1l;
        }

        long half =  power(A,B/2);

        if (B % 2 == 0){
            return half * half;
        }else{
            return half * half * A;
        }
    }
}
