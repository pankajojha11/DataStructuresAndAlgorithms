package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesOfAnagrams {

    private static int countOccurrencesOfAnagrams(String s, String ptr, int k) {
        int i = 0;
        int j = 0;
        int ans = 0;
        Map<Character, Integer> ptrCharacterCountMap = new HashMap<>();
        for (Character ch : ptr.toCharArray()) {
            ptrCharacterCountMap.put(ch, ptrCharacterCountMap.getOrDefault(ch, 0) + 1);
        }
        int mapCount = ptrCharacterCountMap.size();
        while (j < s.length()) {
            // calculation
            if (ptrCharacterCountMap.containsKey(s.charAt(j))) {
                ptrCharacterCountMap.replace(s.charAt(j), ptrCharacterCountMap.get(s.charAt(j)) - 1);
                if (ptrCharacterCountMap.get(s.charAt(j)) == 0)
                    mapCount--;
            }
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                // ans from calculations
                if (mapCount == 0)
                    ans++;
                // slide the window remove ith value
                if (ptrCharacterCountMap.containsKey(s.charAt(i))) {
                    ptrCharacterCountMap.replace(s.charAt(i), ptrCharacterCountMap.get(s.charAt(i)) + 1);
                    if (ptrCharacterCountMap.get(s.charAt(i)) > 1)
                        mapCount++;
                }

                i++;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "forxxorfxdofr";
        String ptr = "for";
        int k = ptr.length();
        System.out.println(countOccurrencesOfAnagrams(s, ptr, k));
    }


}
