package psprecursion;

public class Factorial {


    public static void main(String[] args) {
        int A = 5;
        int fact = solve(5);
        System.out.println(fact);
    }

    public static int solve(int A) {

        if(A == 0) return 1;

        return A*solve(A-1);
    }
}
