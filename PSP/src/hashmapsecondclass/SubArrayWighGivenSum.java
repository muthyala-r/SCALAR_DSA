package hashmapsecondclass;

import java.util.ArrayList;

public class SubArrayWighGivenSum {

    public static void main(String[] args) {
        /*
        Given an array of positive integers A and an integer B,
        find and return first continuous subarray which adds to B.
If the answer does not exist return an array with a single integer "-1".

First sub-array means the sub-array for which starting index in minimum.

A = [1, 2, 3, 4, 5]
 B = 5
 output : [2, 3]
 [2, 3] sums up to 5.
         */
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        long n = A.size();
        int l = 0, r = 0;
        long sum = A.get(l);
        while (r < n) {
            if (sum == B) {
                // current window sum = B
                int[] ans = new int[r - l + 1];
                for (int i = l; i <= r; i++) ans[i - l] = A.get(i);
                ArrayList<Integer> list =     new ArrayList();
                for(int i = 0 ; i < ans.length; i++){
                    list.add(ans[i]);
                }
                return list;
            } else if (sum < B) {
                // current window sum < B
                r++;
                if (r < n) sum += A.get(r);
            } else {
                // current window sum > B
                sum -= A.get(l);
                l++;
                if (l > r && l < n - 1) {
                    r++;
                    sum += A.get(r);
                }
            }
        }
        int ans[] = new int[1];
        ans[0] = -1;
        ArrayList<Integer> lst =     new ArrayList();
        for(int i = 0 ; i < ans.length; i++){
            lst.add(ans[i]);
        }
        return lst;

    }


    public int[] solve1(int[] A, int B) {
        long n = A.length;
        int l = 0, r = 0;
        long sum = A[l];
        while (r < n) {
            if (sum == B) {
                // current window sum = B
                int[] ans = new int[r - l + 1];
                for (int i = l; i <= r; i++) ans[i - l] = A[i];
                return ans;
            } else if (sum < B) {
                // current window sum < B
                r++;
                if (r < n) sum += A[r];
            } else {
                // current window sum > B
                sum -= A[l];
                l++;
                if (l > r && l < n - 1) {
                    r++;
                    sum += A[r];
                }
            }
        }
        int ans[] = new int[1];
        ans[0] = -1;
        return ans;
    }

}
