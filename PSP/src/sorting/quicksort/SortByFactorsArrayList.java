package sorting.quicksort;

import java.util.*;

public class SortByFactorsArrayList {

    // Function to count the number of divisors of a number
    private static int countFactors(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                count++; // i is a factor
                if (i != num / i) {
                    count++; // num/i is also a factor (avoid duplicate counting)
                }
            }
        }
        return count;
    }

    public static List<Integer> sortArrayByFactors(List<Integer> numbers) {
        // Sort using custom comparator
        numbers.sort((a, b) -> {
            int factorsA = countFactors(a);
            int factorsB = countFactors(b);

            // Sort by number of factors (ascending)
            if (factorsA != factorsB) {
                return factorsA - factorsB;
            }
            // If factor count is same, sort by numeric value (ascending)
            return a - b;
        });

        return numbers;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 5, 20, 9, 16));

        List<Integer> sortedNumbers = sortArrayByFactors(numbers);

        // Print sorted list
        System.out.println(sortedNumbers);
    }
}
