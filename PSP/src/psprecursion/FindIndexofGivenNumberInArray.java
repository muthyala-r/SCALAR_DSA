package psprecursion;

import java.util.ArrayList;

public class FindIndexofGivenNumberInArray {


    public int FirstIndex(ArrayList<Integer> A, int B) {
        return printIndex(A,B,0);
    }

    public int printIndex(ArrayList<Integer> A, int B, int index) {

        if(index == A.size()){
            return -1;
        }

        if(A.get(index) == B){
            return index;
        }

        return printIndex(A , B , index+1);
    }
}
