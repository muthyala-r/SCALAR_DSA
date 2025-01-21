package psp;

import java.util.ArrayList;

public class CountingSubArray {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();

        list.add(2);
        list.add(5);
        list.add(6);

        int B = 10;
        int num = solve(list,B);
        System.out.println(num);
    }
    public static int solve(ArrayList<Integer> A, int B) {
        int n  = A.size();
        int pref[] = new int[n];
        pref[0]=A.get(0);
        int ans=0;
        for(int i=1;i<n;i++)pref[i]=pref[i-1]+A.get(i);
        for(int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                int sum = pref[j];
                if(i>0){
                    sum -= pref[i-1];
                }
                if(sum < B) ans++;
            }
        }
        return ans;
    }
}
