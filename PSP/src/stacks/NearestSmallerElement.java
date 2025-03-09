package stacks;

import java.util.*;

public class NearestSmallerElement {
    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : A) {
            while (!stack.isEmpty() && stack.peek() >= num) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }
            stack.push(num);
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4, 5, 2, 10, 8));
        System.out.println(prevSmaller(A)); // Output: [-1, 4, -1, 2, 2]

        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(3, 2, 1));
        System.out.println(prevSmaller(B)); // Output: [-1, -1, -1]
    }
}
