package com.sheet;

public class MaximumSumSubarray {

    // kadane's algorithm
    private static int maximumSumSubarray(int[] arr) {
        int currSum = arr[0];
        int overallSum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (currSum >= 0)
                currSum += arr[i];
            else
                currSum = arr[i];
            if (currSum > overallSum)
                overallSum = currSum;
        }
        return overallSum;
    }

    private static int maximumProductSubarray(int[] arr) {
        int currProduct = arr[0];
        int overallProduct = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (currProduct >= 0)
                currProduct *= arr[i];
            else
                currProduct = arr[i];
            if (currProduct > overallProduct)
                overallProduct = currProduct;
        }
        return overallProduct;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maximumSumSubarray(arr));
        System.out.println(maximumProductSubarray(arr));
    }

}
