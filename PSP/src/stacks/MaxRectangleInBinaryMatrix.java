package stacks;

import java.util.*;

public class MaxRectangleInBinaryMatrix {
    
    // Function to compute largest rectangle area in a histogram
    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i]; // Sentinel to empty the stack
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        if (A == null || A.size() == 0) return 0;
        
        int rows = A.size();
        int cols = A.get(0).size();
        int[] heights = new int[cols];
        int maxArea = 0;
        
        for (ArrayList<Integer> row : A) {
            // Update histogram heights
            for (int j = 0; j < cols; j++) {
                heights[j] = (row.get(j) == 0) ? 0 : heights[j] + 1;
            }
            // Calculate the largest rectangle for the current histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        
        return maxArea;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A1 = new ArrayList<>();
        A1.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        A1.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        A1.add(new ArrayList<>(Arrays.asList(1, 0, 0)));
        System.out.println(maximalRectangle(A1)); // Output: 4

        ArrayList<ArrayList<Integer>> A2 = new ArrayList<>();
        A2.add(new ArrayList<>(Arrays.asList(0, 1, 0)));
        A2.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        System.out.println(maximalRectangle(A2)); // Output: 3
    }
}
