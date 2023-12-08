package com.slidingwindownew;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    private static boolean permutationInString(String s, String t) {
        int i = 0;
        int j = 0;
        int matched = 0;
        Map<Character, Integer> countOfCharacterMap = new HashMap<>();
        for (Character c : t.toCharArray()) {
            countOfCharacterMap.put(c, countOfCharacterMap.getOrDefault(c, 0) + 1);
        }
        while (j < s.length()) {
            if (countOfCharacterMap.containsKey(s.charAt(j))) {
                countOfCharacterMap.replace(s.charAt(j), countOfCharacterMap.get(s.charAt(j)) - 1);
                if (countOfCharacterMap.get(s.charAt(j)) == 0)
                    matched++;
            }
            if (j - i + 1 < t.length())
                j++;
            else if (j - i + 1 == t.length()) {
                if (matched == countOfCharacterMap.size()) {
                    return true;
                }

                if (countOfCharacterMap.containsKey(s.charAt(i))) {
                    countOfCharacterMap.replace(s.charAt(i), countOfCharacterMap.get(s.charAt(i)) + 1);
                    if (countOfCharacterMap.get(s.charAt(i)) == 1) {
                        matched--;
                    }
                }

                i++;
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "eidboaoo";
        String t = "ab";
        System.out.println(permutationInString(s, t));
    }


}
