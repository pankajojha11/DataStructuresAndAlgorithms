package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayOfSumKWithNegativeNumbers {
    private static int longestSubarrayOfSumK(int[] arr, int k) {
        Map<Integer, Integer> mapOfSum = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxSize = Integer.MIN_VALUE;
        int sum = 0;
        while (j < arr.length) {
            // calculation
            sum = sum + arr[j];
            if (sum < k)
                j++;
            else if (sum == k) {
                maxSize = Math.max(maxSize, j - i + 1);
                j++;
            } else if (sum > k) {
                while (sum > k) {
                    sum = sum - arr[i];
                    i++;
                }
                j++;
            }
        }
        return maxSize;
    }


    public static void main(String[] args) {
        int[] arr = {4, 1, 1, -2, 1, 5};
        int k = 5;
        System.out.println(longestSubarrayOfSumK(arr, k));
    }
}
