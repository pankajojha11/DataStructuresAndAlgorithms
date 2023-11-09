package com.recursion;

public class Qus3 {
    private static boolean palindrome(String s) {
        // replace all symbols, punctuation, and spaces with ""
        s = s.replaceAll("[\\W]", "");
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "racecar1!!!!";
        System.out.print(palindrome(s));

    }


}
