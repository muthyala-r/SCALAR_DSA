package psp;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersArray {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        int n =  A.size();
        int maxFromRight = Integer.MIN_VALUE;


        ArrayList<Integer> leaders = new ArrayList();


        for(int i =n-1 ; i >=0;i--){

            if(A.get(i) >maxFromRight){
                maxFromRight = A.get(i);
                leaders.add(maxFromRight);
            }
        }

        Collections.reverse(leaders);
        return leaders;
    }
}
