package psp;

import java.util.ArrayList;

public class GoodSubArray {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int B = 4;

        int  n = solve(list,4);
        System.out.println(n);
    }

    public static int solve(ArrayList<Integer> A, int B) {


        int n = A.size();
        int pref[] = new int[n];
        pref[0] = A.get(0);
        int ans = 0;
        for(int i = 1 ; i < n ; i++){
            pref[i] = pref[i - 1] + A.get(i);
        }
        for(int i = 0 ; i < n ; i++){
            for (int j = i ; j < n ; j++){
                int sz = j - i + 1;
                int sum;
                if(i == 0){
                    sum = pref[j];
                }
                else{
                    sum = pref[j] - pref[i - 1];
                }
                if(sz % 2 == 0 && sum < B)ans++;
                if(sz % 2 == 1 && sum > B)ans++;
            }
        }
        return ans;


    }
}
