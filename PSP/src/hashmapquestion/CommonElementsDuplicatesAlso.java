package hashmapquestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommonElementsDuplicatesAlso {

    public static void main(String[] args) {
        /*
        Given two integer arrays, A and B of size N and M,
        respectively. Your task is to find all the common elements in both the array.
        NOTE:
        Each element in the result should appear as many times as it appears in both arrays.
        The result can be in any order.
        A = [1, 2, 2, 1]
        B = [2, 3, 1, 2]   output: [1, 2, 2]
         */
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.

        Map<Integer,Integer> freqMap1 = new HashMap();

        for(int num: A){
            freqMap1.put(num, freqMap1.getOrDefault(num,0)+1);
        }

        Map<Integer,Integer> freqMap2 = new HashMap();

        for(int num: B){
            freqMap2.put(num, freqMap2.getOrDefault(num,0)+1);
        }

        ArrayList<Integer> commonElement = new ArrayList<Integer>();

        for(int num : B){
            if(freqMap1.containsKey(num) && freqMap1.get(num)>0 && freqMap2.get(num)>0
                    && freqMap1.get(num) == freqMap2.get(num)){
                commonElement.add(num);
            }
            if(freqMap1.containsKey(num) && freqMap1.get(num)>=1 && freqMap2.get(num)>=1 &&
                    freqMap1.get(num) != freqMap2.get(num) &&
                    !commonElement.contains(num)){
                commonElement.add(num);

            }
        }

        return commonElement;
    }


    public ArrayList<Integer> solve1(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer, Integer> a = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> b = new HashMap<Integer, Integer>();
        for(int x: A){
            a.put(x, a.getOrDefault(x, 0)+1);
        }
        for(int x: B){
            b.put(x, b.getOrDefault(x, 0)+1);
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int k: a.keySet()){
            if(b.containsKey(k)){
                for(int i = 0; i < Math.min(a.get(k), b.get(k)); ++i){
                    ans.add(k);
                }
            }
        }
        return ans;
    }

}
