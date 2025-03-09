package stacks;

import java.util.*;

public class RedundantBraces {
    public static int checkRedundantBraces(String A) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : A.toCharArray()) {
            if (ch == ')') {
                boolean hasOperator = false;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasOperator = true;
                    }
                }
                stack.pop(); // Remove '('
                
                // If no operator was found inside '()', it's redundant
                if (!hasOperator) {
                    return 1;
                }
            } else {
                stack.push(ch);
            }
        }
        
        return 0; // No redundant braces found
    }

    public static void main(String[] args) {
        System.out.println(checkRedundantBraces("(a+b)"));      // Output: 0 (not redundant)
        System.out.println(checkRedundantBraces("(a)"));        // Output: 1 (redundant)
        System.out.println(checkRedundantBraces("((a+b))"));    // Output: 1 (redundant)
        System.out.println(checkRedundantBraces("(a+(b/c))"));  // Output: 0 (not redundant)
        System.out.println(checkRedundantBraces("((a*b)+(c/d))"));// Output: 0 (not redundant)
    }
}
