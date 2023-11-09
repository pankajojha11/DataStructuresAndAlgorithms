package com.dp.longestcommonsubsequence;

public class LongestCommonSubsequenceMemorization {


    static int lcs(String x, String y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];
        // filling the matrix with -1
        for (int i = 0; i < m + 1; i++)
            for (int j = 0; j < n + 1; j++)
                t[i][j] = -1;
        // base  condition
        if (m == 0 || n == 0)
            return 0;
        // if not -1 then return the value
        if (t[m][n] != -1)
            return t[m][n];
//        choice diagram
        if (x.charAt(m - 1) == y.charAt(n - 1))
            t[m][n] = 1 + lcs(x, y, m - 1, n - 1);
        else
            t[m][n] = Math.max(lcs(x, y, m - 1, n), lcs(x, y, m, n - 1));
        return t[m][n];
    }

    public static void main(String[] args) {
        String x = "AGGTAB";
        String y = "GXTXAYB";
        int m = x.length();
        int n = y.length();
        System.out.println("Length of LCS is"
                + " " + lcs(x, y, m, n));
    }
}
