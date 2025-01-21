package PSPAssignment;

import java.util.ArrayList;

public class RotateMatrixNintyDegrees {

    public void solve(ArrayList<ArrayList<Integer>> A) {


        for(int row =0 ; row <A.size();row++){

            for(int col = row+1; col < A.get(row).size();col++){

                int temp = A.get(row).get(col);
                A.get(row).set(col,A.get(col).get(row));
                A.get(col).set(row,temp);
            }
        }

        for(int row = 0;row < A.size();row++){

            int start =0 ; int end = A.get(row).size()-1;

            while(start < end){

                int temp = A.get(row).get(start);
                A.get(row).set(start,A.get(row).get(end));
                A.get(row).set(end, temp);
                start++;
                end--;
            }
        }


    }
}
