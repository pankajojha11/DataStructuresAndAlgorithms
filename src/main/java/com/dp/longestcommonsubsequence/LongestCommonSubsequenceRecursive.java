package com.dp.longestcommonsubsequence;

public class LongestCommonSubsequenceRecursive {
    static int lcs(String x, String y, int m, int n) {
        // base  condition
        if (m == 0 || n == 0)
            return 0;
//        choice diagram
        if (x.charAt(m - 1) == y.charAt(n - 1))
            return 1 + lcs(x, y, m - 1, n - 1);
        else
            return Math.max(lcs(x, y, m - 1, n), lcs(x, y, m, n - 1));
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
