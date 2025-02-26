package sorting.binarysearch;

public class SquareRootBinarySearch {
    public static int sqrt(int num) {
        if (num < 2) return num; // Handle 0 and 1

        int left = 1, right = num, result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoids overflow
            long square = (long) mid * mid;

            if (square == num) return mid;
            if (square < num) {
                result = mid; // Store possible answer
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result; // Floor value of sqrt
    }

    public static void main(String[] args) {
        int num = 50;
        System.out.println("Square root of " + num + " is: " + sqrt(num));
    }
}
