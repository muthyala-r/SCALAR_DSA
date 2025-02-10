package hashmapquestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FirstRepetingIndex {

    public static void main(String[] args) {
       // A = [10, 5, 3, 4, 3, 5, 6]  output: 5
        // A = [6, 10, 5, 4, 9, 120]  output:  -1
    }
    public int solve(ArrayList<Integer> A) {

        Map<Integer,Integer> map  = new HashMap<>();
        int firstRepeatingIndex = -1;

        for(int i = 0 ; i < A.size(); i++){
            int num = A.get(i);

            if(map.containsKey(num)){

                if(firstRepeatingIndex ==  -1 || map.get(num) < firstRepeatingIndex){
                    firstRepeatingIndex = map.get(num);
                }
            }else{
                map.put(num, i);
            }
        }

        if(firstRepeatingIndex != -1){
            return A.get(firstRepeatingIndex);
        }
        return -1;
    }
}
