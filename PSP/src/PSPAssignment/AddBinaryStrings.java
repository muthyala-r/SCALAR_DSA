package PSPAssignment;

public class AddBinaryStrings {

    public static void main(String[] args) {
        String A ="100";
        String B ="11";
        String result = addBinary(A, B);
        System.out.println("Binary result: " + result);
    }

    public static String addBinary(String A, String B) {
        StringBuilder result = new StringBuilder();
        int i = A.length()-1;
        int j = B.length()-1;
        int carry = 0;

        while(i>=0 || j>=0 || carry >0){
            int sum = carry;
            if(i>=0){
                sum += A.charAt(i) -'0';
                i--;
            }

            if(j>=0){
                sum += B.charAt(j) - '0';
                j--;
            }
            result.append(sum % 2);
            carry = sum/2;
        }
        return result.reverse().toString();
    }
}
