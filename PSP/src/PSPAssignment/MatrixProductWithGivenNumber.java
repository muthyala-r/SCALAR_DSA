package PSPAssignment;

import java.util.ArrayList;

public class MatrixProductWithGivenNumber {

    public static void main(String[] args) {
      /*  A = [[1, 2, 3],
                [4, 5, 6],
                [7, 8, 9]]
      output:
      [[2, 4, 6],
       [8, 10, 12],
       [14, 16, 18]]
     */
    }
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {

        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        for(int row= 0 ; row<A.size();row++){

            ArrayList<Integer> scalarProduct = new ArrayList<Integer>();

            for(int col= 0; col<A.get(row).size();col++){
                scalarProduct.add(A.get(row).get(col)*B);
            }
            resultList.add(scalarProduct);

        }
        return resultList;
    }
}
