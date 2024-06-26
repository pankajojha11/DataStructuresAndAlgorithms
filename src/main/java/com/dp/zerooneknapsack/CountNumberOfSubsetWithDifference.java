package com.dp.zerooneknapsack;

public class CountNumberOfSubsetWithDifference {

    static int countSubsetWithDifference(int[] arr, int diff, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int s1 = diff + sum / 2;
        return isSubsetSum(arr, s1, n);
    }

    private static int isSubsetSum(int[] arr, int sum, int n) {
        int[][] t = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0)
                    t[i][j] = 0;
                if (j == 0)
                    t[i][j] = 1;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j] + t[i - 1][j - arr[i - 1]];
                else if (arr[i - 1] > j)
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 1, 2, 3};
        int diff = 1;
        int n = arr.length;
        System.out.println(countSubsetWithDifference(arr, diff, n));
    }

}
