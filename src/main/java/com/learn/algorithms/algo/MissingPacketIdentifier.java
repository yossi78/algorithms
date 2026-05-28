package com.learn.algorithms.algo;

/**
 * זיהוי מזהה החבילה החסר — First Missing Positive / Missing Packet ID.
 * <p>
 * רכיב ה-Buffer של כרטיס הרשת ב-Firewall קולט זרם פאקטים; לכל פאקט מזהה שלם.
 * חלק מהפאקטים לא הגיעו. המערך {@code packetIds} מכיל את המזהים שנקלטו בפועל
 * (לא ממוינים, ועשויים לכלול שליליים, אפסים או מספרים עצומים).
 * <p>
 * מחזיר את המספר השלם החיובי הקטן ביותר (מ-1) שאינו מופיע במערך — לבקשת שידור חוזר.
 * <p>
 * עקרון שובך היונים: עם {@code N} איברים, התשובה תמיד בטווח {@code 1..N+1}.
 * מספרים מחוץ לטווח {@code [1, N]} אינם רלוונטיים.
 * <p>
 * Time: O(N) — מעבר על הקלט + מעבר על מערך הסימונים.
 * Space: O(N) — מערך בוליאני {@code present} בגודל {@code N + 1}.
 */
public final class MissingPacketIdentifier {

    private MissingPacketIdentifier() {
    }

    /**
     * @param packetIds מזהי פאקטים שנקלטו בפועל
     * @return המספר החיובי הקטן ביותר שאינו מופיע ב-{@code packetIds}
     */
    public static int solution(int[] packetIds) {
        if (packetIds == null || packetIds.length == 0) {
            return 1;
        }

        int n = packetIds.length;
        boolean[] present = new boolean[n + 1];

        for (int id : packetIds) {
            if (id >= 1 && id <= n) {
                present[id] = true;
            }
        }

        for (int candidate = 1; candidate <= n; candidate++) {
            if (!present[candidate]) {
                return candidate;
            }
        }

        return n + 1;
    }
}
