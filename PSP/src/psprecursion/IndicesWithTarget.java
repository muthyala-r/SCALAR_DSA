package psprecursion;

import java.util.ArrayList;

public class IndicesWithTarget {

    public static void main(String[] args) {
        //A = [8, 9, 5, 6, 5, 5]
       // B = 5

    }
    public static ArrayList<Integer> allIndices(ArrayList<Integer> A, int B) {

        ArrayList<Integer> result = indices(A, B, 0);

        return result;
    }

    public static ArrayList<Integer> indices(ArrayList<Integer> A, int B, int index){
        if(index == A.size()){
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> list = indices(A,B,index+1);
        if(A.get(index) == B){
            list.add(index);
        }
        return list;
    }
}
