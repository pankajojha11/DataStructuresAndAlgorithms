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

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 0, 8, 3};
        int k = 3;
        System.out.println(maximumSumSubarrayOfSizeK(arr, k));
    }

}
