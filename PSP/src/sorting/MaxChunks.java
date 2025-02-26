package sorting;

public class MaxChunks {
    public static void main(String[] args) {
        /*
        Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)], if we split the array into some number of "chunks" (partitions), and individually sort each chunk. After concatenating them in order of splitting, the result equals the sorted array.

What is the most number of chunks we could have made?

 A = [1, 2, 3, 4, 0] output: 1
 To get the 0 in the first index, we have to take all elements in a single chunk.

 A = [2, 0, 1, 3]  output : 2
 We can divide the array into 2 chunks.
 First chunk is [2, 0, 1] and second chunk is [3].
         */
    }
    public int solve(int[] A) {
        int cnt = 0, ma = 0, i = 0;
        for (int x: A) {
            ma = Math.max(ma, x);
            // checks if the maximum number so far equals the index number
            if (ma == i)
                cnt += 1;
            i += 1;
        }
        return cnt;
    }

}
