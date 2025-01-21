package PSPAssignment;

public class LongestSubstring {

    public static void main(String[] args) {
        String str = "aaaabaaa";

        int n =longestPalindrome(str);
        System.out.println(n);
    }

    public static int longestPalindrome(String A) {

        int maxLen =0;
        int n = A.length();
        String str ="";

        for(int i =0 ; i< n ;i++){

            int p1 =i-1;
            int p2 = i+1;

            while(p1>=0 && p2 < n && A.charAt(p1)==A.charAt(p2)){
                maxLen = Math.max(maxLen, p2-p1+1);
                p1--;
                p2++;
            }

            p1 = i;
            p2 = i+1;

            while(p1>=0 && p2 < n && A.charAt(p1)==A.charAt(p2)){
                maxLen = Math.max(maxLen,p2-p1+1);
                p1--;
                p2++;

            }
        }

        return maxLen;

    }
}
