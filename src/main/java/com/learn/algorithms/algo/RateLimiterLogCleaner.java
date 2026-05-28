package com.learn.algorithms.algo;
import java.util.HashMap;
import java.util.Map;

/* 
בתוך 10 דקות ניתן לקבל את אותו סוג התראה פעם אחת בלבד.
אם זה חוזר על עצמו בזמן קצר מ-10 דקות, מפולטר.
הפונקציה תחזיר את מספר ההתראות שנשמרו.
*/

public class RateLimiterLogCleaner {
    public int solution(int[] timestamps, String[] alerts) {
        // פינת הגנה (Edge Case)
        if (timestamps == null || alerts == null || timestamps.length == 0) {
            return 0;
        }

        // מפה לשמירת: מפתח = סוג התראה, ערך = הזמן האחרון שבו היא אושרה
        Map<String, Integer> lastApprovedTime = new HashMap<>();
        int savedCount = 0;

        for (int i = 0; i < alerts.length; i++) {
            String currentAlert = alerts[i];
            int currentTime = timestamps[i];

            // אם ההתראה כבר הופיעה בעבר
            if (lastApprovedTime.containsKey(currentAlert)) {
                int lastTime = lastApprovedTime.get(currentAlert);
                
                // אם עברו פחות מ-10 שניות, נתעלם ממנה (נפלטר)
                if (currentTime - lastTime < 10) {
                    continue; 
                }
            }

            // אם הגענו לכאן, ההתראה מאושרת!
            // נעדכן את הזמן שלה במפה ונגדיל את המונה
            lastApprovedTime.put(currentAlert, currentTime);
            savedCount++;
        }

        return savedCount;
    }
}