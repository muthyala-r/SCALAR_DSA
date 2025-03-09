package stacks;

import java.util.*;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int removed = stack.pop();
            if (removed == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        
        // Example Test Case 1
        minStack.push(1);
        minStack.push(2);
        minStack.push(-2);
        System.out.println(minStack.getMin()); // Output: -2
        minStack.pop();
        System.out.println(minStack.getMin()); // Output: 1
        System.out.println(minStack.top());    // Output: 2

        // Example Test Case 2
        MinStack minStack2 = new MinStack();
        System.out.println(minStack2.getMin()); // Output: -1
        minStack2.pop();
        System.out.println(minStack2.top());    // Output: -1
    }
}
