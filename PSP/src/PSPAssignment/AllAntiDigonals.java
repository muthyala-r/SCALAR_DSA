package PSPAssignment;

import java.util.ArrayList;

public class AllAntiDigonals {

    public static void main(String[] args) {
        /* input
        1 2 3
        4 5 6
        7 8 9
         */

        /* output
        1 0 0
        2 4 0
        3 5 7
        6 8 0
        9 0 0*/
    }

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {

        int n = A.size();
        int m = A.get(0).size();
        ArrayList<ArrayList<Integer>> antidiagonalList = new ArrayList();

        for(int col = 0;col < m;col++){
            int i =0,j = col;
            ArrayList<Integer> antidiagonal = new ArrayList();
            while(i<n&&j>=0){
                antidiagonal.add(A.get(i).get(j));
                i++;
                j--;
            }
            antidiagonalList.add(antidiagonal);
        }

        for(int row =1;row<n;row++){
            int i =row,j =m-1;
            ArrayList<Integer> antidiagonal = new ArrayList();
            while(i<n&&j>=0){
                antidiagonal.add(A.get(i).get(j));
                i++;
                j--;
            }
            antidiagonalList.add(antidiagonal);

        }



        int size = 0;

        for(ArrayList<Integer> list:antidiagonalList){
            size = Math.max(size,list.size());
        }
        ArrayList<ArrayList<Integer>> resultList = new ArrayList();
        for(ArrayList<Integer> list:antidiagonalList){
            ArrayList<Integer> newArray = new ArrayList();
            for(int i = 0;i<size;i++){
                if(list.size()>i ){
                    newArray.add( list.get(i));
                }else{
                    newArray.add(0);
                }
            }
            resultList.add(newArray);
        }
        return resultList;
    }
}
