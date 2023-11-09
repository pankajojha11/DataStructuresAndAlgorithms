package com.dp.matrixchainmultification;

public class ScrambleString {

    private static boolean isScramble(String a, String b) {
        if (a.length() != b.length())
            return false;
        if (a.isEmpty() && b.isEmpty())
            return true;
        if (a.compareTo(b) == 0)
            return true;
        if (a.length() <= 1)
            return false;

        int n = a.length();
        boolean flag = false;
        for (int i = 1; i < n - 1; i++) {
            if (isScramble(a.substring(0, i), b.substring(n - i, i)) == true && isScramble(a.substring(i, n - i), b.substring(0, n - i)) == true ||
                    isScramble(a.substring(0, i), b.substring(0, i)) == true && isScramble(a.substring(i, n - i), b.substring(i, n - i)) == true) {
                flag = true;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String a = "great";
        String b = "rgeat";
        System.out.println(isScramble(a, b));
    }
}
