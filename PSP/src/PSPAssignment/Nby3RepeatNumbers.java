package PSPAssignment;

import java.util.List;

public class Nby3RepeatNumbers {

    public int repeatedNumber(final List<Integer> a) {
        int n = a.size();
        int count1 = 0, count2 = 0;
        int first =  Integer.MIN_VALUE;;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (first == a.get(i))
                count1++;
            else if (second == a.get(i))
                count2++;
            else if (count1 == 0) {
                count1++;
                first = a.get(i);
            }
            else if (count2 == 0) {
                count2++;
                second = a.get(i);
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i = 0; i < n; i++) {
            if (a.get(i) == first)
                count1++;
            else if (a.get(i) == second)
                count2++;
        }

        if (count1 > n / 3)
            return first;

        if (count2 > n / 3)
            return second;

        return -1;

    }
}
