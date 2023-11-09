package com.dp.unboundedknapsack;

public class CoinChange2MinNumberOfWays {
    // get the min number of ways to get sum
    private static int coinChange(int[] coin, int sum, int n) {
        int[][] t = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (j == 0)
                    t[i][j] = 0;
                if (i == 0)
                    t[i][j] = Integer.MAX_VALUE - 1;
            }
        }
        for (int i = 1, j = 1; j < sum + 1; j++) {
            if (j % coin[0] == 0)
                t[i][j] = j / coin[0];
            else
                t[i][j] = Integer.MAX_VALUE - 1;
        }
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coin[i - 1] <= j)
                    t[i][j] = Math.min(1 + t[i][j - coin[i - 1]], t[i - 1][j]);
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][sum];
    }

    public static void main(String[] args) {
        int[] coin = new int[]{1, 2, 3};
        int sum = 5;
        int n = coin.length;
        System.out.println(coinChange(coin, sum, n));
    }


}
