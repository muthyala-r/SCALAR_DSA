package psprecursion;

public class FibonaciSeries {

    public static void main(String[] args) {
        int A = 7;
       int result = findAthFibonacci(A);
        System.out.println(result);
    }

    public static int findAthFibonacci(int A) {

        if(A == 0) return 0;

        if(A == 1) return 1;

        return findAthFibonacci(A-1)+findAthFibonacci(A-2);
    }
}
