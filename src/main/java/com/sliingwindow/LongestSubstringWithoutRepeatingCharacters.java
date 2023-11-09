package com.sliingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    private static int longestSubstringWithoutRepeatingCharacters(String s) {
        int i = 0, j = 0;
        int maxSize = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        while (j < s.length()) {
            // calculation
            countMap.put(s.charAt(j), countMap.getOrDefault(s.charAt(j), 0) + 1);
//            if (countMap.size() < j - i + 1)
//                j++;
            if (countMap.size() == j - i + 1) {
                // and from calculation
                maxSize = Math.max(maxSize, j - i + 1);
                j++;
            } else if (countMap.size() < j - i + 1) {
                while (countMap.size() < j - i + 1) {
                    countMap.put(s.charAt(i), countMap.get(s.charAt(i)) - 1);
                    if (countMap.get(s.charAt(i)) == 0) countMap.remove(s.charAt(i));
                    i++;
                }
                j++;
            }

        }
        return maxSize;
    }


    public int lengthOfLongestSubstring(String s) {
        int a_pointer = 0;
        int b_pointer = 0;
        int max = 0;
        Set<Character> hash_set = new HashSet<>();
        while (b_pointer < s.length()) {
            if (!hash_set.contains(s.charAt(b_pointer))) {
                hash_set.add(s.charAt(b_pointer));
                b_pointer++;
                max = Math.max(hash_set.size(), max);
            } else {
                hash_set.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(longestSubstringWithoutRepeatingCharacters(s));

    }



}
