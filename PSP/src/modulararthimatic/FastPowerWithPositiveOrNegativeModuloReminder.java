package modulararthimatic;

public class FastPowerWithPositiveOrNegativeModuloReminder {

    public static void main(String[] args) {
        int A = 2 , B = 3 , C = 3 ;
        int reminder = pow(A, B, C);
        System.out.println(reminder);

    }


    public static int pow(int A, int B, int C) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        int result = power(A,B,C);

        return result;
    }

    public static int power(int base, int exponent, int modulus){

        if(base == 0){
            return 0;
        }
        if(exponent == 0){
            return 1;
        }
        long ans = power(base,exponent/2,modulus)%modulus;
        if(exponent % 2 == 0){
            ans =  (ans * ans)%modulus;
        }else{
            ans = (ans * ans)%modulus * base;
        }

        ans = (ans+modulus)%modulus;
        return (int)ans;
    }
}

