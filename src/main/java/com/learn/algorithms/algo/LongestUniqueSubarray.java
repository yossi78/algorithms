package com.learn.algorithms.algo;

import java.util.HashSet;
import java.util.Set;

/**
למצוא תת מערך עם הכי הרבה איברים
בתנאי שאיבר יכול להופיע רק פעם אחת.
חלון זז
 */


/**
* Finds the length of the longest contiguous subarray where every element appears at most once.
 * <p>
 * Time: O(N), Space: O(N).
 */
public final class LongestUniqueSubarray {

    private LongestUniqueSubarray() {
    }

    /**
     * @param a virus identifiers (may be null or empty)
     * @return length of the longest valid contiguous subarray, or 0 if {@code a} is null/empty
     */
    public static int solution(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        Set<Integer> window = new HashSet<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < a.length; right++) {
            while (window.contains(a[right])) {
                window.remove(a[left]);
                left++;
            }
            window.add(a[right]);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
