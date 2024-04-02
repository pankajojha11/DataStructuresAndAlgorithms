package com.dp.zerooneknapsack;

public class KnapsackByTopdown {
    // Recursive fun
    // 1. memorize 2. top-down
    static int knapSack(int[] wt, int[] val, int W, int n) {
        // matrix for memorization
        int[][] t = new int[n + 1][W + 1];
        // fill with 0 for n = 0 and W = 0
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }
        // choice diagram
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j)
                    // formula
                    // V[i,w] = max {P[i] + V[i - 1, w - w[i]], V[i - 1, w]}
//                   t[n][W] = Math.max(val[n - 1] + knapSack(wt, val, W - wt[n - 1], n - 1), knapSack(wt, val, W, n - 1));
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                else if (wt[i - 1] > j)
                    t[i][j] = t[i - 1][j];
            }
        }
//        for (int i = 0; i < n+1; i++) {
//            for (int j = 0; j < W+1; j++) {
//                if (i == 0 || j == 0)
//                    t[i][j] = 0;
//                else if (wt[i - 1] <= j)
//                     t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
//                else
//                     t[i][j] = t[i - 1][j];
//            }
//        }

        // abdul bari
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < W + 1; j++) {
//                if (i == 0 || j == 0)
//                    t[i][j] = 0;
//                else if (wt[i] <= j)
//                    t[i][j] = Math.max(val[i] + t[i - 1][j - wt[i]], t[i - 1][j]);
////                     t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
//                else
//                    t[i][j] = t[i - 1][j];
//            }
//        }
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
