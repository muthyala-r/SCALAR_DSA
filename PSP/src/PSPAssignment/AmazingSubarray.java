package PSPAssignment;

public class AmazingSubarray {

    public static void main(String[] args) {

    }
    public int solve(String A) {

        int n =A.length();
        int mod =10003;
        int count = 0;

        for(int i =0 ; i<n ;i++){
            char c = A.charAt(i);
            c = Character.toLowerCase(c);
            if(c=='a' || c=='e'  || c=='i' || c=='o' || c=='u'){
                count = (count+ (n-i)%mod)%mod;
            }
        }
        return count;
    }
}
