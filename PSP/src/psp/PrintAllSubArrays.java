package psp;

import java.util.ArrayList;

public class PrintAllSubArrays {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        ArrayList<ArrayList<Integer>> result = solve(list);
        System.out.println(result);
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>>  resultList = new ArrayList();
        for(int i =0 ;i<A.size();i++){

            for(int j = i; j<A.size() ;j++){
                resultList.add( print(A,i,j));
            }
        }

        return resultList;

    }

    public static ArrayList<Integer> print(ArrayList<Integer> A, int start, int end){

        ArrayList<Integer>  list = new ArrayList();
        for(int i = start; i<= end;i++){
            list.add(A.get(i));
        }

        return list;
    }
}
