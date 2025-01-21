package PSPAssignment;

import java.util.ArrayList;

public class RowsWithMaximumNumberofOnes {

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int maxRowIndex = -1;
        int col = m-1;
        for(int row = 0; row < n ;row++){

            while(col >=0 && A.get(row).get(col) == 1){
                maxRowIndex = row;
                col--;
            }
        }

        return maxRowIndex;
    }
}
