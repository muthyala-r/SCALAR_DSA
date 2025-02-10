package psprecursion;

import java.util.ArrayList;

public class TowersOfHonoiList {

    int curr;
    int[][]ans;
    public ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {


        curr = 0;
        int m = (1 << A) - 1;
        ans = new int[m][3];
        rec(A, 1, 3 );

        ArrayList<ArrayList<Integer>> resultlist = new ArrayList();

        for(int i = 0 ; i < ans.length;i++){
            ArrayList<Integer>  list = new ArrayList();
            list.add(ans[i][0]);
            list.add(ans[i][1]);
            list.add(ans[i][2]);
            resultlist.add(list);
        }
        return resultlist;

    }

    public void rec(int disk, int start, int end){
        if(disk == 1){
            ans[curr++] = new int[]{disk, start, end};
            return;
        }
        // move top (disk - 1) disks from start to buffer, using end as a buffer
        rec(disk - 1, start, 6 - start - end);
        // move top from start to end
        ans[curr++] = new int[]{disk, start, end};
        // move top (disk - 1) disks from buffer to end, using start as a buffer
        rec(disk - 1, 6 - start - end, end);
    }

    public static void main(String[] args) {
        int A = 2;
    }
}
