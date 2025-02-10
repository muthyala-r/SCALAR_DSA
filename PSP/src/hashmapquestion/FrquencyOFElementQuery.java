package hashmapquestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FrquencyOFElementQuery {
    public static void main(String[] args) {
        /*A = [1, 2, 1, 1]
        B = [1, 2]  output: [3, 1]
         */

    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        Map<Integer,Integer> map = new HashMap();

        for( int num : A){

            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }

        ArrayList<Integer> result = new ArrayList();
        for(int freq : B){

            result.add(map.getOrDefault(freq,0));
        }

        return result;
    }
}
