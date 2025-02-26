package sorting.binarysearch;

import java.util.*;

public class BookAllocation {
    public static int minPages(ArrayList<Integer> A, int B) {
        if (B > A.size()) return -1; // If students are more than books, impossible to allocate
        
        int low = Collections.max(A); // Min pages = Largest book
        int high = sum(A); // Max pages = All books combined
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAllocate(A, B, mid)) { // Check if we can allocate within `mid` pages
                result = mid;
                high = mid - 1; // Try reducing max pages
            } else {
                low = mid + 1; // Increase pages limit
            }
        }
        return result;
    }

    // Function to check if we can allocate books to B students with max `maxPages`
    private static boolean canAllocate(ArrayList<Integer> A, int B, int maxPages) {
        int studentCount = 1, currentPages = 0;

        for (int pages : A) {
            if (currentPages + pages > maxPages) {
                studentCount++;
                currentPages = pages;
                if (studentCount > B) return false;
            } else {
                currentPages += pages;
            }
        }
        return true;
    }

    // Function to calculate sum of elements in ArrayList
    private static int sum(ArrayList<Integer> A) {
        int sum = 0;
        for (int num : A) sum += num;
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(12, 34, 67, 90));
        int B = 2;
        System.out.println(minPages(A, B)); // Output: 113
    }
}
