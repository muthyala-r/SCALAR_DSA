package queue;

import java.util.*;

public class FirstKNumbersWith123 {
    public static List<Integer> findNumbers(int A) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // Initializing queue with base numbers
        queue.add(1);
        queue.add(2);
        queue.add(3);

        while (result.size() < A) {
            int num = queue.poll(); // Get the smallest number
            result.add(num);

            // Generate next numbers by appending 1, 2, and 3
            if (result.size() < A) queue.add(num * 10 + 1);
            if (result.size() < A) queue.add(num * 10 + 2);
            if (result.size() < A) queue.add(num * 10 + 3);
        }
        return result;
    }

    public static void main(String[] args) {
        int A = 7;
        System.out.println(findNumbers(A)); // Output: [1, 2, 3, 11, 12, 13, 21]
    }
}
