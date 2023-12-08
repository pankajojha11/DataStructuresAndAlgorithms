package com.slidingwindownew;

import java.util.ArrayList;
import java.util.List;

public class MaximumSumSubarrayOfSizeK {

    private static int solve(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        while (j < arr.length) {
            // calculation
            sum += arr[j];
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                // get ans from calculation
                ans = Math.max(ans, sum);
                // remove ith value slide window
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 5};
        int k = 2;
        System.out.println(solve(arr, k));
    }

}
