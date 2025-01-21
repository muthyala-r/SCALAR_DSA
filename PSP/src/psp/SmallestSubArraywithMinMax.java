package psp;

import java.util.ArrayList;

public class SmallestSubArraywithMinMax {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(1);
        list.add(4);
       int num = solve(list);
        System.out.println(num);
    }

        public static int solve(ArrayList<Integer> A) {


            if(A.size() ==0 || A == null){
                return 0;
            }
            if(A.size() == 1 ){
                return 1;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for( int num : A){
                min = Math.min(min,num);
                max = Math.max(max,num);
            }

            if(min==max){
                return 1;
            }

            int minIndex  = -1 ;
            int maxIndex = -1;
            int smallestlength = Integer.MAX_VALUE;
            for(int i =0; i<A.size();i++){

                if(min == A.get(i)){
                    minIndex = i;
                    if(maxIndex != -1){
                        smallestlength = Math.min(smallestlength, i-maxIndex+1);
                    }
                }

                if(max == A.get(i)){
                    maxIndex = i;

                    if(minIndex != -1){
                        smallestlength= Math.min(smallestlength, i-minIndex+1);
                    }
                }

            }

            return smallestlength;

        }


}
