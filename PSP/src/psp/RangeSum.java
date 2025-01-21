package psp;

import java.util.ArrayList;

public class RangeSum {

    public static void main(String[] args) {

        // A = [1, 2, 3, 4, 5]
        // B = [[0, 3], [1, 2]]

        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);

        ArrayList<ArrayList<Integer>> B = new ArrayList();
        ArrayList<Integer> c = new ArrayList<Integer>();
        c.add(0);
        c.add(3);
        ArrayList<Integer> d = new ArrayList<Integer>();
        d.add(1);
        d.add(2);
        B.add(c);
        B.add(d);


        ArrayList<Long> l = rangeSum(A, B);
        System.out.println(l);


    }

    public static ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {


        int[] pf = new int[A.size()];
        pf[0] = A.get(0);

        for (int i = 1; i < pf.length; i++) {
            pf[i] = pf[i - 1] + A.get(i);
        }

        ArrayList<Long> result = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {

            int start = B.get(i).get(0);
            int end = B.get(i).get(1);

            long sum = 0;

                if(start ==0){
                    sum += pf[end];
                }else{
                    sum += pf[end]-pf[start-1];
                }

            result.add(sum);

        }
        return result;
    }

    public long[] rangeSum(int[] A, int[][] B) {
        int n = A.length;
        int m = B.length;
        long[] pref = new long[n + 1];
        pref[0] = A[0];
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + A[i];   // Sum from the 0th to the i-th index
        }
        long[] ans = new long[m];
        for (int i = 0; i < m; i++) {
            ans[i] = pref[B[i][1]] - (B[i][0] > 0 ? pref[B[i][0] - 1] : 0);
        }
        return ans;
    }

}
