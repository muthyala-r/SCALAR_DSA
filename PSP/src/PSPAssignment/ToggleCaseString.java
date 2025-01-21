package PSPAssignment;

public class ToggleCaseString {

    public static void main(String[] args) {
        String str = "Hello";
        String result = solve(str);
        System.out.println(result);
    }
    public static String solve(String A) {

        StringBuilder toggleCase = new StringBuilder();
        for(int i =0; i<A.length();i++){

            char c = A.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                toggleCase.append((char)(c+32));
            }else{
                toggleCase.append((char)(c-32));
            }
        }
        return toggleCase.toString();

    }
}
