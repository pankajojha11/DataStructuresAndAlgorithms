package com.sliingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacters {

    private static int longestSubstringWithKUniqueCharacters(String s, int k) {
        int i = 0, j = 0;
        int maxSize = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        while (j < s.length()) {
            // calculation
            countMap.put(s.charAt(j), countMap.getOrDefault(s.charAt(j), 0) + 1);
            if (countMap.size() < k) {
                j++;
            } else if (countMap.size() == k) {
                // ans from calculation
                maxSize = Math.max(maxSize, j - i + 1);
                j++;
            } else if (countMap.size() > k) {
                while (countMap.size() > k) {
                    countMap.put(s.charAt(i), countMap.get(s.charAt(i)) - 1);
                    if (countMap.get(s.charAt(i)) == 0)
                        countMap.remove(s.charAt(i));
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
