package com.sliingwindow;

import java.util.ArrayList;

public class MaximumSumSubarrayOfSizeK {
    // sliding window ---> max subarray k

    private static int maximumSumSubarrayOfSizeK(int[] arr, int k) {
        int i = 0, j = 0;
        int max = 0;
        int sum = 0;
        while (j < arr.length) {
            sum += arr[j];
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                max = Math.max(sum, max);
                sum -=arr[i];
                j++;
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 0, 8, 3};
        int k = 3;
        System.out.println(maximumSumSubarrayOfSizeK(arr, k));
    }


}
