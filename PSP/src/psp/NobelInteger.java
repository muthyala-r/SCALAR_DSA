package psp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NobelInteger {

    /*public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
      int noblecount =  solve(list);
        System.out.println(noblecount);
    }*/

    public static int solve(ArrayList<Integer> A) {

            Collections.sort(A, Collections.reverseOrder());
            int count_less = 0;
            int count  = 0;

            if(A.get(0) == 0){
                count++;
            }

            for(int i =1 ; i< A.size();i++){

                if(A.get(i) == A.get(i-1)){
                    count_less = i;
                }

                if(A.get(i) == count_less){
                    count++;
                }
            }
            if(count > 0){
                return count;
            }else{
                return -1;
            }

        }

    public static void findNobleInteger(int[] arr) {
        Arrays.sort(arr);  // Sort the array to simplify comparison
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            // Check if the current element equals the count of numbers greater than it
            if (i < n - 1 && arr[i] == arr[i + 1]) {
                continue;  // Skip duplicate elements
            }
            if (arr[i] == n - i - 1) {
                System.out.println("A Noble Integer is: " + arr[i]);
                return;
            }
        }

        System.out.println("No Noble Integer found.");
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 3};
        findNobleInteger(array);
    }
}