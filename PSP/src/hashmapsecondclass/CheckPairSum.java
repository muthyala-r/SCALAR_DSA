package hashmapsecondclass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CheckPairSum {

    public static void main(String[] args) {
      /*
      A = 8
        B = [3, 5, 1, 2, 1, 2]  output : 1
       */
    }

    public int solve(int A, ArrayList<Integer> B) {

        Set<Integer> set = new HashSet();

        for(int num : B){
            int x = A-num;

            if(set.contains(x)){
                return 1;
            }else{
                set.add(num);
            }
        }

        return 0;
    }
}
