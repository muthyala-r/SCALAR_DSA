package stacks;

import java.util.*;

public class InfixToPostfix {
    public static String convertToPostfix(String A) {
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : A.toCharArray()) {
            if (Character.isLetter(ch)) {
                output.append(ch);  // Operand, add to output
            } else if (ch == '(') {
                stack.push(ch);  // Opening bracket, push to stack
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                stack.pop();  // Remove '(' from stack
            } else {  // Operator
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    if (ch == '^' && stack.peek() == '^') break; // Right-associative handling
                    output.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        return output.toString();
    }

    private static int precedence(char op) {
        switch (op) {
            case '^': return 3;
            case '*': case '/': return 2;
            case '+': case '-': return 1;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(convertToPostfix("x^y/(a*z)+b")); // Output: xy^az*/b+
        System.out.println(convertToPostfix("a+b*(c^d-e)^(f+g*h)-i")); // Output: abcd^e-fgh*+^*+i-
    }
}
