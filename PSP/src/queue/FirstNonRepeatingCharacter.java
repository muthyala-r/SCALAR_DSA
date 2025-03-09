package queue;

import java.util.*;

public class FirstNonRepeatingCharacter {
    public static String findFirstNonRepeating(String A) {
        Map<Character, Integer> freqMap = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (char ch : A.toCharArray()) {
            // Increment frequency in the map
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            // Add character to queue
            queue.add(ch);

            // Remove characters from the queue if they are repeating
            while (!queue.isEmpty() && freqMap.get(queue.peek()) > 1) {
                queue.poll();
            }

            // Append first non-repeating character or '#' if none exist
            result.append(queue.isEmpty() ? '#' : queue.peek());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String A1 = "abadbc";
        String A2 = "abcabc";
        System.out.println(findFirstNonRepeating(A1)); // Output: "aabbdd"
        System.out.println(findFirstNonRepeating(A2)); // Output: "aaabc#"
    }
}
