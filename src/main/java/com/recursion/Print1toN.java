package com.recursion;

public class Print1toN {
    private static void solve(int n) {
        // base condition
        if (n == 1) {
            System.out.println(n);
            return;
        }
        // hypothesis
        solve(n - 1);
        // induction
        System.out.println(n);

    }

    public static void main(String[] args) {
        int n = 7;
        solve(n);
    }


}
