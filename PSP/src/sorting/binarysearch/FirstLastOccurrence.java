package sorting.binarysearch;

public class FirstLastOccurrence {
    public static int findFirstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, firstIndex = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                firstIndex = mid;
                high = mid - 1;  // Keep searching on the left side
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return firstIndex;
    }

    public static int findLastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, lastIndex = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                lastIndex = mid;
                low = mid + 1;  // Keep searching on the right side
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return lastIndex;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int B = 10;

        int firstIndex = findFirstOccurrence(A, B);
        int lastIndex = findLastOccurrence(A, B);

        System.out.println("[" + firstIndex + "," + lastIndex + "]");
    }
}
