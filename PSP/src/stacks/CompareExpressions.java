package stacks;

import java.util.*;

public class CompareExpressions {
    public static int areExpressionsSame(String A, String B) {
        Map<Character, Integer> exprA = normalizeExpression(A);
        Map<Character, Integer> exprB = normalizeExpression(B);
        
        return exprA.equals(exprB) ? 1 : 0;
    }

    private static Map<Character, Integer> normalizeExpression(String expr) {
        Stack<Integer> signStack = new Stack<>();
        signStack.push(1);  // Default global sign is '+'

        Map<Character, Integer> operandMap = new HashMap<>();
        int currentSign = 1;

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (ch == '+') {
                continue; // Skip explicit '+'
            } else if (ch == '-') {
                currentSign = -1 * signStack.peek(); // Flip based on top of stack
            } else if (ch == '(') {
                signStack.push(currentSign);
            } else if (ch == ')') {
                signStack.pop();
            } else { // Operand (a-z)
                int finalSign = currentSign * signStack.peek();
                operandMap.put(ch, operandMap.getOrDefault(ch, 0) + finalSign);
                currentSign = 1; // Reset sign
            }
        }

        return operandMap;
    }

    public static void main(String[] args) {
        System.out.println(areExpressionsSame("-(a+b+c)", "-a-b-c")); // Output: 1
        System.out.println(areExpressionsSame("a-b-(c-d)", "a-b-c-d")); // Output: 0
        System.out.println(areExpressionsSame("a+(b+c)", "a+b+c")); // Output: 1
        System.out.println(areExpressionsSame("a-(b-c+d)", "a-b+c-d")); // Output: 1
    }
}
