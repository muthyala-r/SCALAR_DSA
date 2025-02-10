package modulararthimatic;

public class LargestCoprimeDivisor {

    public int gcd(int x , int y){
        if( y == 0){
            return x;
        }

        return gcd(y, x%y);
    }
    public int cpFact(int A, int B) {

        int maxCoprimeDivisor = 1;

        for(int i = 1; i <= Math.sqrt(A); i++){

            if(A % i == 0){
                if(gcd(i,B) == 1){
                    maxCoprimeDivisor = Math.max(maxCoprimeDivisor,i);
                }

                int complementaryDivisor = A/i;
                if(gcd(complementaryDivisor, B) == 1){
                    maxCoprimeDivisor = Math.max(maxCoprimeDivisor, complementaryDivisor);
                }
            }
        }

        return maxCoprimeDivisor;
    }
}
