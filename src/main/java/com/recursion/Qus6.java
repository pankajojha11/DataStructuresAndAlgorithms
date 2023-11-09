package com.recursion;

public class Qus6 {
    private static boolean armStrong(int num) {
        int ans = 0;
        int result = num;
        int rem = 0;
        while (num > 0) {
            rem = num % 10;
            ans = ans + rem * rem * rem;
            num = num / 10;
        }
        if (result == ans)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int num = 153;
        System.out.println(armStrong(num));
    }
}
