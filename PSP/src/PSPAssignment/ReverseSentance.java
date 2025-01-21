package PSPAssignment;

import java.util.Stack;

public class ReverseSentance {

    public static void main(String[] args) {
        String s = "the sky is blue";
       String result= solve(s);
        System.out.println(result);

    }

    public static String solve(String A) {

        Stack<String> st = new Stack<>();
        for(int i=0;i<A.length();i++){
            String word="";
            while(A.charAt(i)!=' ' && i<A.length()){
                word+=A.charAt(i);
                i++;
            }
            if(word.equals("")){
                continue;
            }
            st.push(word);
        }
        String ans="";
        while(!st.empty()){
            ans+=st.peek();
            st.pop();

            if(st.empty()){
                continue;
            }
            ans+=" ";
        }
        return ans;

    }
    public static String solve1(String A) {

        String[] str = A.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = str.length-1;i>=0;i--){
            if(i == 0){
                result.append(str[i]);
            }else{
                result.append(str[i]+" ");
            }
        }
        return result.toString();
    }
}
