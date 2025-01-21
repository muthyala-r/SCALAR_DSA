package Contest;

import java.util.ArrayList;

public class SuperStreamOfEngineers {

    public static void main(String[] args) {

    }
        public int solve(ArrayList<Integer> A, int B, int C) {

            int n = A.size();



            for(int i =0; i<n-B ;i++){

                int j = i;
                int k = 1;
                float result  =0.0f ;
                while(k <=B){
                    result += A.get(j);
                    j++;
                    k++;

                }

                if(result/B < C){
                    return 1;
                }
            }
            return 0;
        }



}
