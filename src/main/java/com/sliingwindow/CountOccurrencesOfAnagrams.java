package com.sliingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesOfAnagrams {

    private static int countOccurrencesOfAnagrams(String s, String ptr, int k) {
        int i = 0, j = 0;
        int maxOccurancesCount = 0;
        Map<Character, Integer> characterCountMap = new HashMap<>();
        for (char c : ptr.toCharArray()) {
            characterCountMap.put(c, characterCountMap.getOrDefault(c, 0) + 1);
        }
        int count = characterCountMap.size();
        while (j < s.length()) {
            // calculation
            if (characterCountMap.get(s.charAt(j)) != null)
                characterCountMap.put(s.charAt(j), characterCountMap.get(s.charAt(j)) - 1);
            if (characterCountMap.get(s.charAt(j)) != null && characterCountMap.get(s.charAt(j)) == 0)
                count--;
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                // get ans from calculation
                if (count == 0)
                    maxOccurancesCount++;
                //remove ith value
                if (characterCountMap.get(s.charAt(i)) != null)
                    characterCountMap.put(s.charAt(i), characterCountMap.get(s.charAt(i)) + 1);
                if (characterCountMap.get(s.charAt(i)) != null && characterCountMap.get(s.charAt(i)) != 0)
                    count++;
                // increment j and i
                j++;
                i++;
            }
        }
        return maxOccurancesCount;
    }

    public static void main(String[] args) {
        String s = "forxxorfxdofr";
        String ptr = "for";
        int k = ptr.length();
        System.out.println(countOccurrencesOfAnagrams(s, ptr, k));
    }


}
