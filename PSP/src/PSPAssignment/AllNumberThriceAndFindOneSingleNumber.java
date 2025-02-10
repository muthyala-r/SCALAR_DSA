package PSPAssignment;

import java.util.List;

public class AllNumberThriceAndFindOneSingleNumber {

    public static void main(String[] args) {
        List<Integer> A = List.of(2,3,2,2,3,4,3);
        int num = singleNumber(A);
        System.out.println(num);
    }

    public static int singleNumber(final List<Integer> A) {
        int ones = 0, twos = 0;

        for (int num : A){
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }


}
