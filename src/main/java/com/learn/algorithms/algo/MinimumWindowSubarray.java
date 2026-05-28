package com.learn.algorithms.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Smallest Subarray with All Target Logs — זיהוי רצף הלוגים הקצר ביותר.
 * <p>
 * מוצא את אורך תת-המערך הרציף הקצר ביותר שמכיל את כל איברי {@code targets}
 * לפחות פעם אחת (לפי תדירות ב-{@code targets}).
 * <p>
 * Time: O(N) — כל מצביע נע רק קדימה.
 * Space: O(M) — M = מספר ערכים ייחודיים ב-{@code targets}.
 */
public final class MinimumWindowSubarray {

    private MinimumWindowSubarray() {
    }

    /**
     * @param logs    רצף אירועי מערכת
     * @param targets חתימת תקיפה — אירועים שחייבים להופיע בחלון
     * @return אורך החלון המינימלי, או 0 אם אין חלון תקף
     */
    public static int solution(int[] logs, int[] targets) {
        if (logs == null || targets == null || targets.length == 0 || logs.length == 0) {
            return 0;
        }

        Map<Integer, Integer> need = new HashMap<>();
        for (int target : targets) {
            need.merge(target, 1, Integer::sum);
        }

        int required = need.size();
        Map<Integer, Integer> inWindow = new HashMap<>();
        int satisfied = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < logs.length; right++) {
            int log = logs[right];
            if (need.containsKey(log)) {
                int count = inWindow.merge(log, 1, Integer::sum);
                if (count == need.get(log)) {
                    satisfied++;
                }
            }

            while (satisfied == required) {
                minLen = Math.min(minLen, right - left + 1);

                int outgoing = logs[left];
                if (need.containsKey(outgoing)) {
                    if (inWindow.get(outgoing).equals(need.get(outgoing))) {
                        satisfied--;
                    }
                    int remaining = inWindow.get(outgoing) - 1;
                    if (remaining == 0) {
                        inWindow.remove(outgoing);
                    } else {
                        inWindow.put(outgoing, remaining);
                    }
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
