package com.recursion;

public class Print {

    static void printNumber1toN(int n) {
        // base condition
        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printNumber1toN(n - 1);
    }

    public static void main(String[] args) {
        int n = 7;
        printNumber1toN(n);
    }
}
