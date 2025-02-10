package hashmapquestion;

import java.util.ArrayList;

public class CountDistinctElement {

    public int solve(ArrayList<Integer> A) {

        return (int)A.stream().distinct().count();
    }
}
