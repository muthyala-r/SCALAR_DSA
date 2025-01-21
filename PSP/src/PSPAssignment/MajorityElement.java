package PSPAssignment;

import java.util.List;

public class MajorityElement {

    public static void main(String[] args) {
        //[2, 1, 2]

    }

    public int majorityElement(final List<Integer> A) {

        int count = 0;
        int candidate = 0;

        for(int num : A){

            if(count == 0){
                candidate = num;
            }
            count += (num == candidate) ? 1 :-1;
        }

        count = 0;

        for(int num : A){
            if(num == candidate){
                count++;
            }
        }

        if( count > A.size()/2){
            return candidate;
        }else{
            return -1;
        }

    }
}
