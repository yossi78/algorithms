package com.learn.algorithms.algo;

/**
 * Max Sum Subarray of Size K — תפוקת שיא של שרתי האבטחה.
 * <p>
 * מוצא חלון זמן רציף של בדיוק {@code K} שניות עם סכום בקשות HTTP מקסימלי.
 * <p>
 * Time: O(N) — מעבר יחיד; כל הזזת חלון היא O(1).
 * Space: O(1).
 */
public final class MaxSumSubarray {

    private MaxSumSubarray() {
    }

    /**
     * @param requests בקשות HTTP לפי שנייה
     * @param k        גודל החלון (שניות)
     * @return סכום מקסימלי של תת-מערך רציף באורך {@code k}, או 0 אם אין חלון תקף
     */
    public static int solution(int[] requests, int k) {
        if (requests == null || k <= 0 || requests.length < k) {
            return 0;
        }

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += requests[i];
        }

        int maxSum = windowSum;
        for (int right = k; right < requests.length; right++) {
            windowSum += requests[right] - requests[right - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
