package com.learn.algorithms.algo;

import java.util.Stack;

/**
 * בודק אם יש סוגר לכל פותח במחרוזת
 * 
 * /



 */
/**
 * מנוע בדיקת תקינות קינון סוגריים (Valid Parentheses).
 * סיבוכיות זמן: (O(N) - מעבר יחיד על המחרוזת.
 * סיבוכיות מקום: (O(N) - במקרה הגרוע ביותר שבו כל הסוגרים פותחים.
 */
public class BracketValidator {

    public int solution(String S) {
        // מקרה קצה: מחרוזת ריקה או null נחשבת תקינה לפי הגדרות המבחן
        if (S == null || S.isEmpty()) {
            return 1;
        }

        Stack<Character> stack = new Stack<>();
        char[] chars = S.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];

            // 1. אם התו הנוכחי הוא סוגר פותח -> דוחפים למחסנית
            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                stack.push(currentChar);
            } 
            // 2. אם התו הנוכחי הוא סוגר סוגר
            else if (currentChar == ')' || currentChar == ']' || currentChar == '}') {
                
                // אם הגענו לסוגר סוגר אבל המחסנית ריקה (אין פותח תואם) -> המחרוזת לא חוקית
                if (stack.isEmpty()) {
                    return 0;
                }

                // מציצים בראש המחסנית כדי לבדוק התאמה
                char lastChar = stack.peek();

                // בודקים אם הסוגר הסוגר הנוכחי מתאים לסוגר הפותח האחרון שנכנס
                if (isFit(lastChar, currentChar)) {
                    stack.pop(); // יש התאמה! מוציאים את הסוגר הפותח מהמחסנית
                } else {
                    return 0; // אין התאמה (למשל קינון של (] ) -> לא חוקי
                }
            }
        }

        // אם בסוף הלולאה המחסנית ריקה לחלוטין -> הכל נסגר כראוי (מחזירים 1)
        // אם נשארו איברים במחסנית (למשל "(((") -> מחזירים 0
        return stack.isEmpty() ? 1 : 0;
    }

    /**
     * פונקציית עזר לבדיקת התאמה בין סוגר פותח לסוגר סוגר.
     */
    private boolean isFit(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}