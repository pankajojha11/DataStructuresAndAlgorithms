package com.slidingwindownew;

public class SmallestSubarrayWithGivenSum {

    private static int solve(int[] arr, int s) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (j < arr.length) {
            // calculations
            sum += arr[j];
            if (sum < s)
                j++;
            else if (sum >= s) {
                // get ans from calculation
                while (sum >= s) {
                    ans = Math.min(ans, j - i + 1);
                    // remove ith value slide window
                    sum -= arr[i];
                    i++;
                }
                j++;
            }
        }
        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 8};
        int s = 7;
        System.out.println(solve(arr, s));
    }

}
