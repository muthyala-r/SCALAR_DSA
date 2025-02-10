package psprecursion;

public class Polindrome {

    public static void main(String[] args) {
        String A = "naman";
        int result  = solve(A);
        System.out.println(result);

    }
    public static int solve(String A) {

        int r = A.length()-1;
        int l = 0;

        boolean flag = isPolindrome(A, l, r);

        if(flag){
            return 1;
        }else{
            return 0;
        }
    }

    public static boolean isPolindrome(String A, int left, int right){

        if(left >= right) return true;


        return  (A.charAt(left) == A.charAt(right) && isPolindrome(A,left+1, right-1));
    }

}
