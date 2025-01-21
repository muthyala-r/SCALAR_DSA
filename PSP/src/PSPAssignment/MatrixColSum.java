package PSPAssignment;

import java.util.ArrayList;

public class MatrixColSum {

    public static void main(String[] args) {
       /* [1,2,3,4]
          [5,6,7,8]
          [9,2,3,4]*/
    }

    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {

        ArrayList<Integer> sumResult = new ArrayList<Integer>();

        for(int col =0 ; col < A.get(0).size();col++){
            int sum = 0;
            for(int row = 0;row<A.size();row++){
                sum += A.get(row).get(col);
            }
            sumResult.add(sum);
        }



        return sumResult;
    }
}
