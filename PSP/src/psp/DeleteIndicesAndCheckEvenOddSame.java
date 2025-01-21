package psp;

import java.util.ArrayList;

public class DeleteIndicesAndCheckEvenOddSame {

    public static void main(String[] args) {
        ArrayList<Integer> indices = new ArrayList<>();
        indices.add(2);
        indices.add(1);
        indices.add(6);
        indices.add(4);
        indices.add(3);
        indices.add(5);

        int solve = sol(indices);
        System.out.println(solve);
    }

    public static int sol(ArrayList<Integer> A) {

        int n = A.size();

        int[] evenprefix = new int[n+1];
        int[] oddprefix = new int[n+1];

        for(int i =0; i<n; i++){

            evenprefix[i+1] = evenprefix[i];
            oddprefix[i+1]  = oddprefix[i];

            if(i%2 == 0){
                evenprefix[i+1] += A.get(i);
            }else{
                oddprefix[i+1] += A.get(i);
            }
        }

        int count  = 0;

        for(int i =0; i<n; i++){
            int evensum = evenprefix[i]+(oddprefix[n]-oddprefix[i+1]);
            int oddsum = oddprefix[i]+(evenprefix[n]-evenprefix[i+1]);

            if(evensum == oddsum){
                count++;
            }
        }
        return count;
    }
}
