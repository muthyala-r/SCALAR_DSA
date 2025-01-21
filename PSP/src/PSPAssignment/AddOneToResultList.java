package PSPAssignment;

import java.util.ArrayList;
import java.util.Collections;

public class AddOneToResultList {

    public static void main(String[] args) {
        /*Given vector is [1, 2, 3].
        The returned vector should be [1, 2, 4] as 123 + 1 = 124.
                [1, 2, 4] */

    }
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        ArrayList<Integer> result = new ArrayList();

        int n = A.size();

        StringBuilder b = new StringBuilder();
        for(int num : A){

            b.append(num);
        }

        int number=  Integer.parseInt(b.toString());
        number +=1;

        while(number != 0){
            int digit = number%10;

            result.add(digit);
            number = number/10;

        }
        Collections.reverse(result);
        return result;
    }
    public ArrayList<Integer> plusOnee(ArrayList<Integer> A) {

        int carry = 1;
        int num;
        int size = A.size();

        // traversing the digits of the number in reverse order
        for (int i = size - 1; i >= 0; i--) {

            num = A.get(i);
            num += carry;
            carry = 0;

            if (num == 10) {
                num = 0;
                carry = 1;
            }

            A.set(i, num);

        }

        ArrayList<Integer> res = new ArrayList<Integer>();

        if (carry == 1)
            res.add(1);

        for (int x : A) {
            if (x == 0 && res.size() == 0)
                continue;
            res.add(x);
        }

        return res;

    }
}
