package PSPAssignment;

import java.util.ArrayList;

public class MatrixRowSum {

    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {


        ArrayList<Integer> resultList = new ArrayList();
        for(int row = 0 ; row<A.size();row++){
            int sum = 0;
            for(int col = 0; col<A.get(row).size();col++){

                sum += A.get(row).get(col);
            }
            resultList.add(sum);
        }
        return resultList;
    }
}
