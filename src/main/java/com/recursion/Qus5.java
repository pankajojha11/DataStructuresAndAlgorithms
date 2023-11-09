package com.recursion;

public class Qus5 {
    private static int reverseNumber(int num) {
        int ans = 0;
        while (num > 0) {
            num = num / 10;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int num = 456;
        System.out.println(reverseNumber(num));
    }
}
