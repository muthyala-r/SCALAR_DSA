package hashmapsecondclass;

import java.util.*;

public class CountPairDifference {
    public static void main(String[] args) {

    }

    public int nonrepeatedNumbers(ArrayList<Integer> A, int B) {
        Set<Integer> set = new HashSet();
        int count = 0;
        for(int num : A){
            if(set.contains(Math.abs(num - B))) count++;
            if(set.contains(Math.abs(num + B))) count++;
            set.add(num);
        }
        return count;
    }

    public int solve(ArrayList<Integer> A, int B) {
        Map<Integer,Integer> freqmap = new HashMap();
        int count = 0;

        for(int num : A){
            freqmap.put(num,freqmap.getOrDefault(num,0)+1);
        }

        for(int num :freqmap.keySet()){

            if(B> 0 && freqmap.containsKey(num+B)){
                count += freqmap.get(num)*freqmap.get(num+B);
            }else if(B==0){
                int freq = freqmap.get(num);
                count += (freq * (freq-1))/2;
            }
        }
        return count;
    }
}
