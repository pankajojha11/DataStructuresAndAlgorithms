package com.slidingwindow;

public class MaximumSumSubarrayOfSizeK {
    private static int maximumSumSubarrayOfSizeK(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int maxSum = 0;

        while (j < arr.length) {
            // calculation
            sum += arr[j];
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                // ans from calculation
                maxSum = Math.max(maxSum, sum);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return maxSum;
    }

    private static int maxSumSubArrayOfSizeK(int[] arr, int k) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - k; i++) {
            for (int j = i; j < i + k; j++) {
                sum = sum + arr[j];
            }
            ans = Math.max(ans, sum);
            sum = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 0, 8, 3};
        int k = 3;
        System.out.println(maximumSumSubarrayOfSizeK(arr, k));
        System.out.println(maxSumSubArrayOfSizeK(arr, k));
    }

}
