package PSPAssignment;

public class CheckAnagram {

    public static void main(String[] args) {
        String A = "secure";
        String B = "rescue";
       int flag = solve(A, B);

        System.out.println("anagram are "+flag);
    }   

    public static int solve(String A, String B) {

        if(A.length() != B.length()){
            return 0;
        }

        int[] charCounts = new int[26];

        for(int i =0; i< A.length();i++){
            charCounts[A.charAt(i) - 'a']++;
            charCounts[B.charAt(i) - 'a']--;
        }

        for(int count : charCounts){
            if(count != 0){
                return 0;
            }
        }

        return 1;
    }
}
