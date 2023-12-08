package com.slidingwindownew;

public class MinimumSizeSubarraySum {
    private static int minimumSizeSubarraySum(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (j < arr.length) {
            sum += arr[j];
            if (sum < k)
                j++;
            else if (sum >= k) {
                // get ans from calculation
                while (sum >= k) {
                    minLength = Math.min(minLength, j - i + 1);
                    // remove ith value slide window
                    sum -= arr[i];
                    i++;
                }
                j++;
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int k = 7;
        System.out.println(minimumSizeSubarraySum(arr, k));
    }


}
