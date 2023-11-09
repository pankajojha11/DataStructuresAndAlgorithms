package com.dp.longestcommonsubsequence;

public class LongestPalindromicSubsequence {

    private static int lcs(String x, String y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++)
            for (int j = 0; j < n + 1; j++)
                if (i == 0 || j == 0)
                    t[i][j] = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }
        return t[m][n];
    }

    public static String reverseWord(String str) {
        String s = "";
        char[] ch = str.toCharArray();
        for (int i = ch.length - 1; i >= 0; i--) {
            s = s + ch[i];
        }
        return s;
    }

    public static void main(String[] args) {
        String x = "bbbab";
        String y = reverseWord(x);
        int m = x.length();
        int n = y.length();
        System.out.println(lcs(x, y, m, n));
    }


}
