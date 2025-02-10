package psprecursion;

import java.util.ArrayList;

public class FindTheLastIndexOfGivenNumber {

    public int LastIndex(ArrayList<Integer> A, int B) {

        return printIndex(A,B,A.size()-1);
    }

    public int printIndex(ArrayList<Integer> A, int B, int index) {

        if(index == -1){
            return -1;
        }

        if(A.get(index) == B){
            return index;
        }

        return printIndex(A , B , index-1);
    }
}
