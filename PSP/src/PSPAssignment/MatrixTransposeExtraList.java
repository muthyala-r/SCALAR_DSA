package PSPAssignment;

import java.util.ArrayList;

public class MatrixTransposeExtraList {

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int col =0; col<A.get(0).size();col++){
            ArrayList<Integer> newRow = new ArrayList();
            for(int row = 0; row<A.size();row++){

                newRow.add(A.get(row).get(col));
            }
            result.add(newRow);
        }

        return result;
    }
}
