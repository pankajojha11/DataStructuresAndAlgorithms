package com.recursion;

public class PrintNto1 {

    private static void solve(int n) {
        // base condition
        if (n == 1) {
            System.out.println(n);
            return;
        }
        // induction
        System.out.println(n);
        // hypothesis
        solve(n - 1);
    }

    public static void main(String[] args) {
        int n = 7;
        solve(n);
    }
}
