package com.learn.algorithms.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * איחוד טווחי תקיפות (Merge Attack Intervals).
 * <p>
 * Time: O(N log N) — מיון לפי זמן התחלה, ואז מעבר יחיד.
 * Space: O(N) — מערך התשובה.
 */
public class AttackTimelineAggregator {

    /**
     * @param intervals טווחי תקיפה {@code [start, end]} (שניות מתחילת היום)
     * @return טווחים מאוחדים, ממוינים לפי התחלה
     */
    public int[][] solution(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] last = merged.get(merged.size() - 1);

            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
