package psp;

public class PrimeNumber {
    public static void main(String[] args) {
        int n = 11;
        isPrimeNumber(n);
    }

    private static void isPrimeNumber(int n) {
        if( pfn(n) == 2){
            System.out.println("Prime number");
        }else{
            System.out.println("not prime number");
        }
    }

    private static int pfn(int n) {
        int count = 0;
        for(int i = 1; i*i <= n; i++){
            if(n%i == 0){
                if(i*i == n){
                    count++;
                }else{
                    count += 2;
                }
            }

        }
        return count;
    }
}
