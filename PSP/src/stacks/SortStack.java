package stacks;

import java.util.*;
//Java Solution using Two Stacks
public class SortStack {
    public static ArrayList<Integer> sortStack(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> sortedStack = new Stack<>();

        // Push elements from input stack to sorted stack
        for (int num : A) {
            // Move elements to find the right place for num
            while (!sortedStack.isEmpty() && sortedStack.peek() > num) {
                stack.push(sortedStack.pop());
            }
            // Insert current element into sorted stack
            sortedStack.push(num);
            // Move back the elements from stack to sortedStack
            while (!stack.isEmpty()) {
                sortedStack.push(stack.pop());
            }
        }

        // Convert sorted stack to ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        while (!sortedStack.isEmpty()) {
            result.add(sortedStack.pop());
        }
        Collections.reverse(result); // Reverse to get sorted order
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A1 = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
        System.out.println(sortStack(A1)); // Expected: [1, 2, 3, 4, 5]

        ArrayList<Integer> A2 = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
        System.out.println(sortStack(A2)); // Expected: [5, 11, 17, 100]
    }
}
