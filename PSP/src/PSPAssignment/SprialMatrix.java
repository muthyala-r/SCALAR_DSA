package PSPAssignment;

import java.util.ArrayList;

public class SprialMatrix {

    public int[][] generateMatrix(int A) {
        int[][] ans = new int[A][A];


        int count = 1;
        int r = 0, c= 0;
        while(A > 1){
            for(int i = 1; i < A; i++){
                ans[r][c] = count;
                c++;
                count++;
            }
            for(int i = 1; i < A; i++){
                ans[r][c] = count;
                r++;
                count++;
            }
            for(int i = 1; i < A; i++){
                ans[r][c] = count;
                c--;
                count++;
            }
            for(int i = 1; i < A; i++){
                ans[r][c] = count;
                r--;
                count++;
            }
            r += 1;
            c += 1;
            A -= 2;
        }

        if(A == 1){
            ans[r][c] = count;
        }
        return ans;
    }


    public ArrayList<ArrayList<Integer>> generateMatrix1(int A) {
        int[][] ans = new int[A][A];


        int count = 1;
        int r = 0, c= 0;
        while(A > 1){
            for(int i = 1; i < A; i++){
                ans[r][c] = count;
                c++;
                count++;
            }
            for(int i = 1; i < A; i++){
                ans[r][c] = count;
                r++;
                count++;
            }
            for(int i = 1; i < A; i++){
                ans[r][c] = count;
                c--;
                count++;
            }
            for(int i = 1; i < A; i++){
                ans[r][c] = count;
                r--;
                count++;
            }
            r += 1;
            c += 1;
            A -= 2;
        }

        if(A == 1){
            ans[r][c] = count;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList();

        for(int row = 0 ; row < ans.length;row++){
            ArrayList<Integer> list = new ArrayList();
            for(int col = 0; col < ans[row].length;col++){
                list.add(ans[row][col]);
            }
            result.add(list);
        }
        return result;
    }
}
