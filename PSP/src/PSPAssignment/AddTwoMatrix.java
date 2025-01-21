package PSPAssignment;

import java.util.ArrayList;

public class AddTwoMatrix {

    public static void main(String[] args) {
        /*
        A = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]

B = [[9, 8, 7],
     [6, 5, 4],
     [3, 2, 1]]

     output :
     [[10, 10, 10],
 [10, 10, 10],
 [10, 10, 10]
         */
    }
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> resultlist = null;
        if(A.size() == B.size()){

            resultlist = new  ArrayList<ArrayList<Integer>>();

            for(int row = 0 ; row < A.size(); row++ ){
                ArrayList<Integer> newRowsum = new ArrayList();
                for(int col= 0 ; col<A.get(row).size();col++){
                    newRowsum.add(A.get(row).get(col)+B.get(row).get(col));
                }
                resultlist.add(newRowsum);
            }
        }

        return resultlist;

    }
}
