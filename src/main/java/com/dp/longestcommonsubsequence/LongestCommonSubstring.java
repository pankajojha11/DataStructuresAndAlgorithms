package com.dp.longestcommonsubsequence;

public class LongestCommonSubstring {

    private static int longestCommonSubstring(String x, String y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];
        int result = 0;
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                    result = Integer.max(result,
                            t[i][j]);
                } else
                    t[i][j] = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String x = "OldSite:GeeksforGeeks.org";
        String y = "NewSite:GeeksQuiz.com";

        int m = x.length();
        int n = y.length();

        System.out.println(
                "Length of Longest Common Substring is "
                        + longestCommonSubstring(x, y, m,
                        n));
    }

}
