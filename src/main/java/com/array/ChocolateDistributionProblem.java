package com.array;

import java.util.Arrays;

public class ChocolateDistributionProblem {
    private static int findMinDiff(int[] arr, int m) {
        //  code changes for testing version control
        int ans = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i <= arr.length - m; i++) {
            int min = arr[i];
            int max = arr[i + m - 1];
            int gap = max - min;
            if (gap < ans)
                ans = gap;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;
        System.out.println(findMinDiff(arr, m));
    }


}
