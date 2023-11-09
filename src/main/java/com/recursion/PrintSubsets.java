package com.recursion;

public class PrintSubsets {
    static void solve(String ip, String op) {
        if (ip.length() == 0) {
            System.out.println(op);
            return;
        }
        String OP1 = op;
        String OP2 = op;
        OP2 += ip.charAt(0);
        ip = ip.substring(1);
        solve(ip, OP1);
        solve(ip, OP2);
        return;

    }

    public static void main(String[] args) {
        String ip = "ab";
        String op = "";
        solve(ip, op);
    }


}
