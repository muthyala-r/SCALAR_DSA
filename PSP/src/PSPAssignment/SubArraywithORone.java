package PSPAssignment;

import java.util.ArrayList;
import java.util.List;

public class SubArraywithORone {

    public static void main(String[] args) {
      List<Integer> A = List.of(0, 0, 1, 1, 0);
      int n = subarraysWithOR1(A);
        System.out.println(n);
    }

    public static  int subarraysWithOR1(List<Integer> A) {
        int n = A.size();
        int totalSubarrays = n*(n+1)/2;
        int zeroSubarrays= 0;

        int countZeros = 0;

        for(int num : A){
            if(num ==0){
                countZeros++;
            }else{
                zeroSubarrays += countZeros * (countZeros + 1)/2;
                countZeros = 0;
            }
        }

        if(countZeros > 0){
            zeroSubarrays += countZeros * (countZeros + 1)/2;
        }

        return totalSubarrays - zeroSubarrays;
    }
}
