package com.slidingwindownew;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacters {

    private static int longestSubstringWithKUniqueCharacters(String s, int k) {
        int i = 0;
        int j = 0;
        int maxSize = 0;
        Map<Character, Integer> uniqueCharacters = new HashMap();
        while (j < s.length()) {
            // calculations
            uniqueCharacters.put(s.charAt(j), uniqueCharacters.getOrDefault(s.charAt(j), 0) + 1);
            if (uniqueCharacters.size() < k)
                j++;
            else if (uniqueCharacters.size() == k) {
                maxSize = Math.max(maxSize, j - i + 1);
                j++;
            } else if (uniqueCharacters.size() > k) {
                while (uniqueCharacters.size() > k) {
                    uniqueCharacters.replace(s.charAt(i), uniqueCharacters.get(s.charAt(i)) - 1);
                    if (uniqueCharacters.get(s.charAt(i)) == 0)
                        uniqueCharacters.remove(s.charAt(i));
                    i++;
                }
                j++;
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(longestSubstringWithKUniqueCharacters(s, k));

    }

}
