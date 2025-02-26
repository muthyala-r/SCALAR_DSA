package sorting;

import java.util.ArrayList;
import java.util.List;

public class MergetwoSortedArrays {

    public ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {

        int n = A.size();
        int m = B.size();
        ArrayList<Integer>  resultlist = new ArrayList();
        int i = 0,j=0,k=0;

        while(i<n && j <m){
            if(A.get(i) < B.get(j)){
                resultlist.add(A.get(i));
                i++;
            }else{
                resultlist.add(B.get(j));
                j++;
            }
        }

        while(i<n){
            resultlist.add(A.get(i));
            i++;
        }

        while(j<m){
            resultlist.add(B.get(j));
            j++;
        }

        return resultlist;
    }
}
