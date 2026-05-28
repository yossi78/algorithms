package com.learn.algorithms.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Subarray Sum Equals K — איזון עומסי שרתים.
 * <p>
 * סופר כמה תתי-מערכים רציפים שסכומם שווה בדיוק ל-{@code k}.
 * Prefix Sum + HashMap (לא Sliding Window — מספרים שליליים שוברים את החלון הקלאסי).
 * <p>
 * Time: O(N).
 * Space: O(N).
 */
public final class SubarraySumEqualsK {

    private SubarraySumEqualsK() {
    }

    /**
     * @param packets זרם פאקטים (מספרים חיוביים, שליליים או אפס)
     * @param k       סכום מטרה
     * @return מספר תתי-מערכים רציפים שסכומם שווה בדיוק ל-{@code k}
     */
    public static int solution(int[] packets, int k) {
        if (packets == null || packets.length == 0) {
            return 0;
        }

        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        int count = 0;
        int currentSum = 0;

        for (int packet : packets) {
            currentSum += packet;
            count += prefixCount.getOrDefault(currentSum - k, 0);
            prefixCount.merge(currentSum, 1, Integer::sum);
        }

        return count;
    }
}
