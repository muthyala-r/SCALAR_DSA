package PSPAssignment;

import java.util.ArrayList;

public class Flip {

    public static void main(String[] args) {

       /* A = "010"

        Pair of [L, R] | Final string
        _______________|_____________
                [1 1]          | "110"
                [1 2]          | "100"
                [1 3]          | "101"
                [2 2]          | "000"
                [2 3]          | "001"
                output: [1, 1]
                */
    }

    public ArrayList<Integer> flip(String A) {
        int cur = 0;
        int maxx = 0, l = 0, r = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(-1);
        ans.add(-1);
        //basic kadane's algorithm implementation
        for(int i = 0 ; i < A.length() ; i++){
            if(A.charAt(i) == '1')
                cur--;
            else
                cur++;
            if(cur > maxx){
                ans.set(0, l+1);
                ans.set(1, r+1);
                maxx = cur;
            }
            if(cur < 0) {
                cur = 0;
                l = i+1;
                r = i+1;
            }
            else
                r++;
        }
        if(maxx == 0){
            return new ArrayList<Integer>();
        }
        else return ans;
    }
}
