package com.sheet.string;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        String fixedString = "";
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c))
                fixedString += c;
        }
        fixedString = fixedString.toLowerCase();

        int a_pointer = 0;
        int b_pointer = fixedString.length() - 1;
        while (a_pointer <= b_pointer) {
            if (fixedString.charAt(a_pointer) != fixedString.charAt(b_pointer))
                return false;
            a_pointer++;
            b_pointer--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

}
