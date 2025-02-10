package PSPAssignment;

import java.util.List;

public class SingleNumber {

    public static void main(String[] args) {
        List<Integer> A = List.of(2,1,2,3,3,4,1);
       int singleNumber =  singleNumber(A);
        System.out.println(singleNumber);
    }

    public static int singleNumber(final List<Integer> A) {

        int result = 0;
        for(int num :A){

            result = result^num;
        }

        return result;
    }
}
