package PSPAssignment;

import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {

    public static void main(String[] args) {
        //A = 23, output :1 B = 236 output : 0
    }

    public static int colorful(int A) {
        String numStr = Integer.toString(A);
        Set<Integer> productSet = new HashSet<>();
        for(int i =0 ; i<numStr.length();i++){
            int product = 1;

            for(int j= i; j< numStr.length();j++){

                product *= Character.getNumericValue(numStr.charAt(j));

                if(!productSet.add(product)){
                    return 0;
                }
            }
        }
        return 1;
    }
}
