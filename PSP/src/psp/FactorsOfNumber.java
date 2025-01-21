package psp;

public class FactorsOfNumber {
    public static void main(String[] args) {
        int n = 100;
        printFactorsOfNumber(n);
    }

    private static void printFactorsOfNumber(int n) {

        int count = 0;
        for (int i = 1; i <=n/i ; i++) {
            if(n%i == 0){
                if(i == n/i){
                    count++;
                }else{
                    count += 2;
                }
            }

        }
        System.out.println(count);


    }
}
