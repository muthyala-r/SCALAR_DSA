package psp;

import java.util.ArrayList;

public class LeastAvgSubArray {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();

        list.add(3);
        list.add(7);
        list.add(90);
        list.add(20);
        list.add(10);
        list.add(50);
        list.add(40);
        int B = 3;
        int num = solve(list,B);
        System.out.println(num);
    }
    private static int findMinAvgSubarray( ArrayList<Integer> list, int n, int k)
    {

        // Initialize  beginning index of result
        int res_index = 0;

        // Compute sum of first subarray of size k
        int curr_sum = 0;
        for (int i = 0; i < k; i++)
            curr_sum += list.get(i);

        // Initialize minimum sum as current sum
        int min_sum = curr_sum;

        // Traverse from (k+1)'th element to n'th element
        for (int i = k; i < n; i++) {
            // Add current item and remove first item of
            // previous subarray
            curr_sum += list.get(i) - list.get(i - k);

            // Update result if needed
            if (curr_sum < min_sum) {
                min_sum = curr_sum;
                res_index = (i - k + 1);
            }
        }
        return res_index;
    }
    public static int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) arr[i] = A.get(i);
        return findMinAvgSubarray(A, n, B);
    }
}
