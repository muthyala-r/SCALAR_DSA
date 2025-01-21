package PSPAssignment;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Raju";
        String rev = solve(str);
        System.out.println(rev);
    }

    public static String solve(String A) {
        char[] charArray = A.toCharArray();
        int left = 0;
        int right = charArray.length-1;

        while(left < right){
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right]= temp;
            left++;
            right--;
        }
        return new String(charArray);
    }
}
