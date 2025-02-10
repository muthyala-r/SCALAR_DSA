package psprecursion;

import java.util.ArrayList;

public class MaxElementInArrayWithRecursion {
    public int getMax(ArrayList<Integer> A) {
        return print(A,0);
    }

    public int print(ArrayList<Integer> A, int index) {

        if( index == A.size()-1){
            return A.get(index);
        }

        return Math.max( A.get(index), print(A,index+1));

    }
}
