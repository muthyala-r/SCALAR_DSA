package PSPAssignment;

import java.util.ArrayList;
import java.util.List;

public class CountIncreasingTriplets {

    public static void main(String[] args) {
       // A = [1, 2, 4, 3]  output : [1, 2, 3] and [1, 2, 4].
        List<Integer> nums = List.of(1, 2, 4, 3);  // Example list
        int n = solve(nums);
        System.out.println(n);

    }

    public static int solve(List<Integer> A) {
        int n =A.size();
        if(n < 3 ){
            return 0;
        }

        List<ArrayList<Integer>> triplets = new ArrayList();
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int firstIndex = -1, secondIndex = -1;

        for(int i=0; i<n;i++){
            if(A.get(i) <= first){
                first = A.get(i);
                firstIndex = i;
            }else if(A.get(i) <= second){
                second = A.get(i);
                secondIndex = i;
            }else{
                ArrayList<Integer> list= new ArrayList();
                list.add(first);
                list.add(second);
                list.add(A.get(i));
                triplets.add(list);
            }
        }

        return triplets.size();
    }

    public static int countIncreasingTriplets(List<Integer> A) {
        int n = A.size();
        int count = 0;
        int[] smaller = new int[n];
        int[] larger = new int[n];

        // Compute smaller[] array where smaller[i] is the count of elements smaller than nums[i] on the left
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(j) < A.get(i)) {
                    smaller[i]++;
                }
            }
        }

        // Compute larger[] array where larger[i] is the count of elements larger than nums[i] on the right
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (A.get(j) > A.get(i)) {
                    larger[i]++;
                }
            }
        }

        // Count triplets using smaller[i] and larger[i]
        for (int i = 0; i < n; i++) {
            count += smaller[i] * larger[i];
        }

        return count;
    }
}


