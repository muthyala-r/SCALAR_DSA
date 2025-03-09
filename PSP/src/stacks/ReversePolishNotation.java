package stacks;

import java.util.*;

public class ReversePolishNotation {
    public int evalRPN(String[] A) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : A) {
            if (isOperator(token)) {
                int a = stack.pop();  // Operand 1 (top)
                int b = stack.pop();  // Operand 2 (next top)
                stack.push(evaluate(b, a, token));  // Apply operation and push result
            } else {
                stack.push(Integer.parseInt(token)); // Convert string to integer and push
            }
        }
        
        return stack.pop(); // Final result
    }

    private boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

    private int evaluate(int b, int a, String operator) {
        switch (operator) {
            case "+": return b + a;
            case "-": return b - a;
            case "*": return b * a;
            case "/": return b / a;  // Integer division (truncates towards zero)
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        ReversePolishNotation rpn = new ReversePolishNotation();
        
        // Test Case 1
        String[] A1 = {"2", "1", "+", "3", "*"};  // (2 + 1) * 3 = 9
        System.out.println(rpn.evalRPN(A1));  // Output: 9

        // Test Case 2
        String[] A2 = {"4", "13", "5", "/", "+"};  // (13 / 5) + 4 = 6
        System.out.println(rpn.evalRPN(A2));  // Output: 6

        // Test Case 3
        String[] A3 = {"10", "6", "9", "3", "/", "-", "*"};  // 10 * (6 - (9/3)) = 10 * 3 = 30
        System.out.println(rpn.evalRPN(A3));  // Output: 30
    }
}
