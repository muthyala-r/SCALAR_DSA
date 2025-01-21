package PSPAssignment;

import java.util.List;

public class RainWaterTrap {

    public int trap(final List<Integer> A) {
        //Array A = [5, 4, 1, 4, 3, 2, 7] output: 11
        int ans  = 0;
        int n = A.size();
        int[] lmax = new int[n];

        for(int i =1 ; i<n;i++){
            lmax[i] = Math.max(lmax[i-1],A.get(i-1));
        }

        int[] rmax = new int[n];

        for(int i =n-2 ; i>=0;i--){
            rmax[i] = Math.max(rmax[i+1],A.get(i+1));
        }

        for(int i =1 ; i<=n-2;i++){
            int water = Math.min(lmax[i],rmax[i])-A.get(i);
            if(water >0){
                ans += water;
            }
        }
        return ans;
    }
}
