package PSPAssignment;

import java.util.ArrayList;

public class SumOfAllSubMatrices {

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int sum =0;
        int n = A.size();

        int m = A.get(0).size();

        for(int i =0; i<A.size();i++){

            for(int j = 0; j <A.get(i).size();j++){
                int freq = ((i+1)*(n-i)*(j+1)*(m-j));
                sum += freq*A.get(i).get(j);
            }
        }
        return sum;
    }

}
