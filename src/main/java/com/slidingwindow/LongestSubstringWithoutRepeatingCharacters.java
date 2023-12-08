package com.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    private static int longestSubstringWithoutRepeatingCharacters(String s) {
        int i = 0;
        int j = 0;
        int maxSize = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < s.length()) {
            // calculations
            map.put(s.charAt(j), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.size() == j - i + 1) {
                // get ans from calculations
                maxSize = Math.max(maxSize, j - i + 1);
                j++;
            } else if (map.size() < j - i + 1) {
                while (map.size() < j - i + 1) {
                    map.replace(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0)
                        map.remove(s.charAt(i));
                    i++;
                }
                j++;
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(longestSubstringWithoutRepeatingCharacters(s));

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


}
