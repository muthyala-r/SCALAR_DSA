package stacks;

import java.util.*;

public class BalancedParentheses {
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);  // Push opening brackets
            } else {
                if (stack.isEmpty()) return false;  // Unmatched closing bracket
                
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) return false;  // Mismatch case
            }
        }
        
        return stack.isEmpty();  // If stack is empty, parentheses are balanced
    }
    
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isBalanced("(){}[]")); // true
        System.out.println(isBalanced("({[]})")); // true
        System.out.println(isBalanced("{[(])}")); // false
        System.out.println(isBalanced("({[})]")); // false
        System.out.println(isBalanced(""));       // true (empty string is balanced)
    }
}
