package stacks;

import java.util.*;

public class FootballPass {
    public static int findFinalPlayer(int A, int B, int[] C) {
        Stack<Integer> stack = new Stack<>();
        stack.push(B);  // Initial player with the ball
        
        for (int pass : C) {
            if (pass == 0) {
                stack.pop();  // Back pass (return to previous player)
            } else {
                stack.push(pass);  // Forward pass (to new player)
            }
        }

        return stack.peek();  // Player who has the ball at the end
    }

    public static void main(String[] args) {
        // Example Test Cases
        int A1 = 10;
        int B1 = 23;
        int[] C1 = {86, 63, 60, 0, 47, 0, 99, 9, 0, 0};
        System.out.println(findFinalPlayer(A1, B1, C1));  // Output: 63

        int A2 = 1;
        int B2 = 1;
        int[] C2 = {2};
        System.out.println(findFinalPlayer(A2, B2, C2));  // Output: 2
    }
}
