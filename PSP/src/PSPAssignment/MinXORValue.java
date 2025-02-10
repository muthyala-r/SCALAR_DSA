package PSPAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinXORValue {

    public static void main(String[] args) {
        List<Integer> values = List.of(9,5,3,10);
        int n  = findMinXor(values);
        System.out.println(n);
    }
    public static int findMinXor(List<Integer> A) {

        Collections.sort(A);
        int n = A.size();
        int mixXOR = Integer.MAX_VALUE;

        for(int i =0; i< n-1;i++){
            int xor = A.get(i) ^ A.get(i+1);
            mixXOR= Math.min(mixXOR, xor);
        }

        return mixXOR;
    }
}
