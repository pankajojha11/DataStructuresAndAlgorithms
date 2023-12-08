package com.slidingwindownew;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    static int minimumWindowSubstring(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count = tMap.size();
        int ans = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        String str = "";
        while (j < s.length()) {
            // calculation
            if (tMap.containsKey(s.charAt(j))) {
                tMap.replace(s.charAt(j), tMap.get(s.charAt(j)) - 1);
                if (tMap.get(s.charAt(j)) == 0) {
                    count--;
                }
            }
            if (count > 0)
                j++;
            else if (count == 0) {
//                ans = Math.min(ans, j - i + 1);
//                str = s.substring(i, j + 1);
                if (j - i + 1 <= ans) {
                    ans = j - i + 1;
                    str = s.substring(i, j + 1);
                }
                if (tMap.containsKey(s.charAt(i))) {
                    tMap.replace(s.charAt(i), tMap.get(s.charAt(i)) + 1);
                    if (tMap.get(s.charAt(i)) > 0)
                        count++;
                }
                i++;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minimumWindowSubstring(s, t));
    }


}
