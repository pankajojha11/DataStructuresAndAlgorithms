package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    static int minimumWindowSubstring(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count = tMap.size();
        int ans = 0;
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            // calculation
            if (tMap.containsKey(s.charAt(j))) {
                tMap.replace(t.charAt(j), tMap.get(t.charAt(j)) - 1);
                if (tMap.get(t.charAt(j)) == 0) {
                    count--;
                }
            } else {

            }
            j++;
            if (count == 0) {
                ans = Math.min(ans, j - i + 1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minimumWindowSubstring(s, t));
    }


}
