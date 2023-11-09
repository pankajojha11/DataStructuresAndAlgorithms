package com.recursion;

public class Qus4 {
    private static int reverseNumber(int num) {
        int ans = 0;
        int rem = 0;
        while (num > 0) {
            rem = num % 10; // 3
            ans = ans * 10 + rem;
            num = num / 10; //
        }
        return ans;
    }

    public static void main(String[] args) {
        int num = 123;
        System.out.println(reverseNumber(num));
    }


}
