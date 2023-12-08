package com.slidingwindownew;

public class AverageOfSubarrayOfSizeK {

    private static double[] solve(int[] arr, int k) {
        double[] avgArray = new double[arr.length - k + 1];
        for (int i = 0; i <= arr.length - k; i++) {
            int sum = 0;
            for (int j = i; j <= k; j++) {
                sum += arr[j];
            }
            avgArray[i] = (double) sum / k;
            System.out.println(avgArray[i]);
        }
        return avgArray;
    }

    static double[] solveWithSlidingWindow(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int sum = 0;
        double[] avgArray = new double[arr.length - k + 1];
        while (j < arr.length) {
            // calculations
            sum += arr[j];
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                // get ans from calculations
                avgArray[i] = (double) sum / k;
                // remove ith value slide the window
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return avgArray;
    }

    private static double findMaxAverage(int[] nums, int k) {
        // if (k > nums.length)
        // 	return 0;
        int i = 0;
        int j = 0;
        double sum = 0;
        double maxAvg = Integer.MIN_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                // get ans from calculations
                // maxAvg = sum / k;
                maxAvg = Math.max(maxAvg, sum / k);
                // remove i
                sum -= nums[i];
                // sliding window
                i++;
                j++;
            }
        }
        return maxAvg;
        }

    public static void main(String[] args) {
//        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
//        int k = 5;
        int[] arr = {-1};
        int k = 1;
        System.out.println(findMaxAverage(arr, k));
        System.out.println(solve(arr, k));
        System.out.println(solveWithSlidingWindow(arr, k));
    }

}
