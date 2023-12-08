package com.slidingwindownew;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithSameLettersAfterReplacement {
    private static int characterReplacement(String s, int k) {
        int i = 0;
        int j = 0;
        int maxSize = 0;
        int maxRepeatLetterCount = 0;
        Map<Character, Integer> countOfCharacterMap = new HashMap<>();
        while (j < s.length()) {
            countOfCharacterMap.put(s.charAt(j), countOfCharacterMap.getOrDefault(s.charAt(j), 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, countOfCharacterMap.get(s.charAt(j)));
            if (j - i + 1 - maxRepeatLetterCount <= k) {
                maxSize = Math.max(maxSize, j - i + 1);
                j++;
            } else {
                countOfCharacterMap.replace(s.charAt(i), countOfCharacterMap.get(s.charAt(i)) - 1);
                maxRepeatLetterCount = Math.max(maxRepeatLetterCount, countOfCharacterMap.get(s.charAt(i)));
                if (countOfCharacterMap.get(s.charAt(i)) == 0)
                    countOfCharacterMap.remove(s.charAt(i));
                i++;
                j++;
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        String s = "BAAA";
        int k = 0;
        System.out.println(characterReplacement(s, k));
    }
}
