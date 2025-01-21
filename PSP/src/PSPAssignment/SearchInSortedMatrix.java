package PSPAssignment;

import java.util.ArrayList;

public class SearchInSortedMatrix {


    public boolean solve1(ArrayList<ArrayList<Integer>> A, int B) {
        int n = A.size();
        int m = A.get(0).size();
        int row = 0;
        int col = m-1;

        while(row < n && col >= 0){

            if(A.get(row).get(col) == B){
                return true;
            }else if(A.get(row).get(col) < B){
                row++;
            }else{
                col--;
            }

        }
        return false;
    }
    public int solve2(int[][] A, int B) {
        int n = A.length, m = A[0].length;
        int i = 0 , j = m - 1, ans = -1;
        while(i < n && j >= 0){
            if(A[i][j] > B){
                j--;
            }
            else if(A[i][j] < B){
                i++;
            }
            else{
                for(int k = j ; k >= 0 ; k--){
                    if(A[i][k] == B){
                        ans = ((i + 1) * 1009 + (k + 1));
                    }
                }
                break;
            }
        }
        return ans;
    }

    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int n = A.size();
        int m = A.get(0).size();
        int row = 0;
        int col = m-1;


        int i = 0 , j = m - 1, ans = -1;
        while(i < n && j >= 0){
            if(A.get(i).get(j) > B){
                j--;
            }
            else if(A.get(i).get(j) < B){
                i++;
            }
            else{
                for(int k = j ; k >= 0 ; k--){
                    if(A.get(i).get(k) == B){
                        ans = ((i + 1) * 1009 + (k + 1));
                    }
                }
                break;
            }
        }
        return ans;


    }

}
