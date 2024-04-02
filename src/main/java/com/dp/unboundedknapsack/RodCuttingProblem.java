package com.dp.unboundedknapsack;

public class RodCuttingProblem {
    // divide the rod in such a way to get max profit
    private static int unbounded(int[] length, int[] price, int N, int n) {
        int[][] t = new int[n + 1][N + 1];
        //intilization
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (length[i - 1] <= j)
                    // unbounded knapsack t[i] because the item can be taken again
                    // 0-1 knapsack t[i-1]
                    t[i][j] = Math.max(t[i - 1][j], price[i - 1] + t[i][j - length[i - 1]]);
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][N];
    }

    public static void main(String[] args) {
        int length[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int N = 8; // length of the rod
        int n = length.length;
        System.out.println(unbounded(length, price, N, n));
    }


}
