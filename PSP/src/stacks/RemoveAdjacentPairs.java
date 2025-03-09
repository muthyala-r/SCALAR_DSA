package stacks;

import java.util.*;

public class RemoveAdjacentPairs {
    public static String removePairs(String A) {
        Stack<Character> stack = new Stack<>();

        for (char ch : A.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();  // Remove the pair
            } else {
                stack.push(ch);  // Add character to stack
            }
        }

        // Build the resulting string from the stack
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(removePairs("abba"));   // Output: "" (all pairs removed)
        System.out.println(removePairs("abccba")); // Output: "" (all pairs removed step-by-step)
        System.out.println(removePairs("aabcca")); // Output: "ca"
        System.out.println(removePairs("abc"));    // Output: "abc" (no pairs to remove)
        System.out.println(removePairs("a"));      // Output: "a" (single character remains)
    }
}
