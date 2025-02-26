package sorting.quicksort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BClosestPointsOrigin {

    public static void main(String[] args) {
        /*
        You are developing a feature for Zomato that helps users find the nearest restaurants to their current location. It uses GPS to determine the user's location and has access to a database of restaurants, each with its own set of coordinates in a two-dimensional space representing their geographical location on a map. The goal is to identify the "B" closest restaurants to the user, providing a quick and convenient way to choose where to eat.

Given a list of restaurant locations, denoted by A (each represented by its x and y coordinates on a map), and an integer B representing the number of closest restaurants to the user. The user's current location is assumed to be at the origin (0, 0).

Here, the distance between two points on a plane is the Euclidean distance.

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2).

A = [
       [1, 3],
       [-2, 2]
     ]
 B = 1

 [ [-2, 2] ]

 The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
 So one closest point will be [-2,2].
         */
    }
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {

        ArrayList <ArrayList<Integer>> ans = new ArrayList <ArrayList <Integer>>();
        // sorts the list based on euclidean distance from origin
        Collections.sort(A, new Comparator<ArrayList <Integer>>() {
            public int compare(ArrayList <Integer> a, ArrayList <Integer> b) {
                long d1 = (long)a.get(0) * a.get(0) + (long)a.get(1) * a.get(1);
                long d2 = (long)b.get(0) * b.get(0) + (long)b.get(1) * b.get(1);
                if(d1 < d2)return -1;
                else if(d2 < d1)return 1;
                else return 0;
            }
        });
        for(int i = 0; i < B; i++){
            ans.add(A.get(i));
        }
        return ans;
    }

    public int[][] solve(int[][] A, int B) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : A) {
            pq.offer(p);
            if (pq.size() > B) {
                pq.poll();
            }
        }
        int[][] res = new int[B][2];
        while (B > 0) {
            res[--B] = pq.poll();
        }
        return res;
    }
}
