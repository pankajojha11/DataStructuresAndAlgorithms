package com.dp.zerooneknapsack;

public class KnapsackByMemorize {
    // Recursive fun
    // 1. memorize 2. top-down
    static int knapSack(int[] wt, int[] val, int W, int n) {
        // matrix for memorization
        int[][] t = new int[n + 1][W + 1];
        // filling the matrix with -1
        for (int i = 0; i < n + 1; i++)
            for (int j = 0; j < W + 1; j++)
                t[i][j] = -1;
        // base condition
        if (n == 0 || W == 0)
            return 0;
        // if not -1 then return the value
        if (t[n][W] != -1)
            return t[n][W];
        // choice diagram
        if (wt[n - 1] <= W)
            // formula
            // V[i,w] = max {P[i] + V[i - 1, w - w[i]], V[i - 1, w]}
            t[n][W] = Math.max(val[n - 1] + knapSack(wt, val, W - wt[n - 1], n - 1), knapSack(wt, val, W, n - 1));
        else if (wt[n - 1] > W)
            t[n][W] = knapSack(wt, val, W, n - 1);
        return t[n][W];
    }

    public static void main(String[] args) {
        int value[] = new int[]{60, 100, 120};
        int weight[] = new int[]{10, 20, 30};
        int W = 50;
        int n = value.length;
        System.out.println(knapSack(weight, value, W, n));
    }


}















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































