package com.learn.algorithms.algo;

/**
 * Max Network Capacity — אופטימיזציית רוחב פס ברשת (Container With Most Water).
 * <p>
 * בוחר שני עמודי תקשורת כך שקיבולת השידור תהיה מקסימלית:
 * {@code (right - left) * min(heights[left], heights[right])}.
 * <p>
 * Time: O(N) — מעבר יחיד עם שני מצביעים.
 * Space: O(1).
 */
public final class MaxNetworkCapacity {

    private MaxNetworkCapacity() {
    }

    /**
     * @param heights גבהי עמודי תקשורת (אינדקס = מיקום בשורה)
     * @return קיבולת מקסימלית בין שני עמודים, או 0 אם אין זוג תקף
     */
    public static int solution(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }

        int left = 0;
        int right = heights.length - 1;
        int maxCapacity = 0;

        while (left < right) {
            int width = right - left;
            int limitingHeight = Math.min(heights[left], heights[right]);
            maxCapacity = Math.max(maxCapacity, width * limitingHeight);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxCapacity;
    }
}
