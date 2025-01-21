package psp;

import java.util.ArrayList;
import java.util.Collections;

public class CostofTheArray {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(2);
        list.add(1);
       int cost = solve(list);
        System.out.println(cost);
    }
    public static int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int cost = 0;

        int n = A.size();

        for(int i = 0; i < n;i++){
            cost += A.get(i)*(n-i);
        }

        return cost;

    }
}
