package psp;

import java.util.ArrayList;
import java.util.Arrays;

public class Equlibrium {


    public static void main(String[] args) {
        int[] arr ={-7,1,5,2,-4,3,0};
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(-7);
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(-4);
        list.add(3);
        list.add(0);
        System.out.println(solve(list));
    }

    public static int solve(ArrayList<Integer> A) {

        int totalSum = 0;;
        int leftsum= 0;
        for(int num : A){
            totalSum += num;

        }

        for (int i = 0 ; i < A.size() ;i++){
            int rightsum = totalSum - leftsum - A.get(i);

            if(leftsum == rightsum){
                return i;
            }

            leftsum += A.get(i);
        }

        return -1;
    }
}
