package PSPAssignment;

import java.util.ArrayList;

public class MergeIntervalsinsertOneMore {

    public ArrayList<ArrayList<Integer>> insert(ArrayList<ArrayList<Integer>> intervals, ArrayList<Integer> newInterval) {
        int start = newInterval.get(0);
        int end = newInterval.get(1);
        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < intervals.size(); i++) {
            ArrayList<Integer> in = intervals.get(i);

            if (start >= in.get(0) && start <= in.get(1))
                startIndex = i;

            if (end >= in.get(0) && end <= in.get(1))
                endIndex = i;
        }

        // Endpoints of new interval don't lie inside any other interval
        if (startIndex == -1 && endIndex == -1) {
            startIndex = 0;

            for (int i = 0; i < intervals.size(); i++) {
                if (start > intervals.get(i).get(1)) {
                    startIndex = i + 1;
                }
            }

            endIndex = intervals.size() - 1;
            for (int i = intervals.size() - 1; i >= 0; i--) {
                if (end < intervals.get(i).get(0)) {
                    endIndex = i - 1;
                }
            }

            // Intervals between startIndex and endIndex lie completely inside the new interval
            for (int i = startIndex; i <= endIndex; i++) {
                intervals.remove(startIndex);
            }

            intervals.add(startIndex, newInterval);
            return intervals;
        }

        if (startIndex == -1) {
            for (int i = intervals.size() - 1; i >= 0; i--) {
                if (start <= intervals.get(i).get(0))
                    startIndex = i;
            }
        }

        if (endIndex == -1) {
            for (int i = 0; i < intervals.size(); i++) {
                if (end >= intervals.get(i).get(1))
                    endIndex = i;
            }
        }

        start = Math.min(intervals.get(startIndex).get(0), start);
        end = Math.max(intervals.get(endIndex).get(1), end);
        intervals.get(startIndex).set(0, start);
        intervals.get(startIndex).set(1, end);

        for (int i = startIndex + 1; i <= endIndex; i++) {
            intervals.remove(startIndex + 1);
        }

        return intervals;
        }
    }
