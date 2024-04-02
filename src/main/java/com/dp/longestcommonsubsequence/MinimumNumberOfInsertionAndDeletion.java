package com.dp.longestcommonsubsequence;

public class MinimumNumberOfInsertionAndDeletion {
    private static int lcs(String a, String b, int m, int n) {
        int[][] t = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }
        return t[m][n];
    }
    
    public static void main(String[] args) {
        String a = "heap";
        String b = "pea";
        int m = a.length();
        int n = b.length();
        System.out.println("Minimum number of deletion : " + (m - lcs(a, b, m, n)));
        System.out.println("Minimum number of insertion : " + (n - lcs(a, b, m, n)));
    }


}
