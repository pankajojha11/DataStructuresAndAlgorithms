package com.slidingwindownew;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithOnesAfterReplacement {

    private static int longestSubarrayWithOnesAfterReplacement(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int maxSize = 0;
        int maxOnesCount = 0;
        Map<Integer, Integer> countOfDigitsMap = new HashMap<>();
        while (j < arr.length) {
            countOfDigitsMap.put(arr[j], countOfDigitsMap.getOrDefault(arr[j], 0) + 1);
            maxOnesCount = Math.max(maxOnesCount, countOfDigitsMap.get(1) == null ? 0 : countOfDigitsMap.get(1));
            if (j - i + 1 - maxOnesCount <= k) {
                maxSize = Math.max(maxSize, j - i + 1);
                j++;
            } else {
                countOfDigitsMap.replace(arr[i], countOfDigitsMap.get(arr[i]) - 1);
                maxOnesCount = Math.max(maxOnesCount, countOfDigitsMap.get(1) == null ? 0 : countOfDigitsMap.get(1));
                if (countOfDigitsMap.get(arr[i]) == 0)
                    countOfDigitsMap.remove(arr[i]);
                i++;
                j++;
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 0;
        System.out.println(longestSubarrayWithOnesAfterReplacement(arr, k));
    }


}
