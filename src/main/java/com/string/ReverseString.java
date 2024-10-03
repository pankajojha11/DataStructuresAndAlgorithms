package com.string;

public class ReverseString {

    // by two pointers
    public static String reverseWordByTwoPointer(String str) {
        int start = 0;
        int end = str.length() - 1;
        char[] ch = str.toCharArray();
        char temp;
        while (start < end) {
            temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return new String(ch);
    }

    // linear iterative way
    public static void reverseWord(String str) {
        char[] ch = str.toCharArray();
        for (int i = ch.length - 1; i >= 0; i--) {
            System.out.print(ch[i] + " ");
        }
    }

    public static void main(String[] args) {
        String str = "Geeks";
        System.out.println(reverseWordByTwoPointer(str));
//        reverseWord(str);
        System.out.println("Hello World");
        System.out.println("Java");
    }
}
