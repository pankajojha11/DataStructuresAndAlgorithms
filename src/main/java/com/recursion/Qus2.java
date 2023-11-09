package com.recursion;

public class Qus2 {

    public static int firstFactorial(int num) {
        int ans = 1;
        for (int i = 1; i <= num; i++) {
            ans = ans * i;
        }
        // code goes here
        return ans;
    }

    public static void main(String[] args) {
        int num = 4;
        System.out.println(firstFactorial(num));
    }
}
