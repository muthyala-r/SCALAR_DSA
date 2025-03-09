package queue;

import java.util.Stack;

class UserQueue {
    private Stack<Integer> stack1; // Main stack for pushing elements
    private Stack<Integer> stack2; // Temporary stack for reversing order

    public UserQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Push element to the back of the queue
    public void push(int X) {
        stack1.push(X);
    }

    // Remove and return the front element of the queue
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Get the front element without removing it
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        UserQueue queue = new UserQueue();

        queue.push(20);
        System.out.println(queue.empty()); // false
        System.out.println(queue.peek());  // 20
        System.out.println(queue.pop());   // 20
        System.out.println(queue.empty()); // true

        queue.push(30);
        System.out.println(queue.peek());  // 30
        queue.push(40);
        System.out.println(queue.peek());  // 30
    }
}
