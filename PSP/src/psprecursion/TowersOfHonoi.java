package psprecursion;

public class TowersOfHonoi {

    int curr;
    int[][]ans;
    public int[][] towerOfHanoi(int A) {
        curr = 0;
        int m = (1 << A) - 1;
        ans = new int[m][3];
        rec(A, 1, 3);
        return ans;
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

}
