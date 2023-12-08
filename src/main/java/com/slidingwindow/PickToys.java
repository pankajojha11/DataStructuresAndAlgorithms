package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PickToys {
    private static int pickToys(String s, int k) {
        int i = 0;
        int j = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < s.length()) {
            // calculation
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if (map.size() < k)
                j++;
            else if (map.size() == k) {
                // get ans from calculations
                ans = Math.max(ans, j - i + 1);
                j++;
            } else if (map.size() > k) {
                while (map.size() > k) {
                    map.replace(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0)
                        map.remove(s.charAt(i));
                    i++;
                }
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abaccab";
        int k = 2;
        System.out.println(pickToys(s, k));
    }
}
