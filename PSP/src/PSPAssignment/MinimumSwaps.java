package PSPAssignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumSwaps {

    public static void main(String[] args) {
       /* A = [5, 17, 100, 11]
        B = 20*/

        List<Integer> list = List.of(1, 12, 10, 3, 14, 10, 5);
        int b =8;
        int bad = solve(list, b);
        System.out.println(bad);

    }

    public static int solve(List<Integer> A, int B) {

        int n = A.size();
        int count = 0;

        // Count how many elements are less than or equal to B
        for (int num : A) {
            if (num <= B) {
                count++;
            }
        }

        if (count == 0 || count == n) {
            return 0; // No swaps needed if all or no elements are <= B
        }

        // Find the number of elements greater than B in the first 'count' elements
        int bad = 0;
        for (int i = 0; i < count; i++) {
            if (A.get(i) > B) {
                bad++;
            }
        }

        int minSwaps = bad;

        // Slide the window of size 'count' across the array
        for (int i = 0, j = count; j < n; i++, j++) {
            if (A.get(i) > B) {
                bad--;  // Remove the effect of the leftmost element
            }
            if (A.get(j) > B) {
                bad++;  // Add the effect of the rightmost element
            }
            minSwaps = Math.min(minSwaps, bad);
        }

        return minSwaps;
    }

    public static int minimumSwaps(ArrayList<Integer> arr) {
        int n = arr.size();
        boolean[] visited = new boolean[n];
        int swaps = 0;

        // Create a list of pairs (element, original index)
        List<Pair<Integer, Integer>> arrWithIndex = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrWithIndex.add(new Pair<>(arr.get(i), i));
        }

        // Sort the array by element value
        arrWithIndex.sort(Comparator.comparingInt(Pair::getKey));

        for (int i = 0; i < n; i++) {
            // Skip if the element is already visited or is in the correct place
            if (visited[i] || arrWithIndex.get(i).getValue() == i) {
                continue;
            }

            // Find the cycle of swaps
            int cycleLength = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = arrWithIndex.get(j).getValue();
                cycleLength++;
            }

            // If there is a cycle of length k, we need k-1 swaps
            if (cycleLength > 1) {
                swaps += cycleLength - 1;
            }
        }

        return swaps;
    }

    /*public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4, 3, 1, 2));
        int result = minimumSwaps(arr);
        System.out.println("Minimum swaps required: " + result);  // Output: 3
    }
*/
    // Helper class for key-value pairs
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
