package PSPAssignment;

public class CountOccurences {

    public static void main(String[] args) {
String st = "abobc";
int result =solve(st);
        System.out.println(result);

    }
    public static int solve(String A) {

        int ans = 0;
        for(int i = 0; i+2 < A.length(); ++i){
            if(A.charAt(i) == 'b' && A.charAt(i+1) == 'o' && A.charAt(i+2) == 'b'){
                ++ans;
            }
        }
        return ans;

    }
}
