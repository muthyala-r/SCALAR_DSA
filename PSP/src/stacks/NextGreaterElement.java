package stacks;

import java.util.*;

public class NextGreaterElement {
    public static ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            int current = A.get(i);
            // Pop elements that are smaller than the current element
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }
            // If stack is not empty, the top is the next greater element
            if (!stack.isEmpty()) {
                result.set(i, stack.peek());
            }
            // Push current element to stack
            stack.push(current);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A1 = new ArrayList<>(Arrays.asList(4, 5, 2, 10));
        System.out.println(nextGreater(A1)); // Expected: [5, 10, 10, -1]

        ArrayList<Integer> A2 = new ArrayList<>(Arrays.asList(3, 2, 1));
        System.out.println(nextGreater(A2)); // Expected: [-1, -1, -1]
    }
}
