package com.recursion;

public class Qus1 {

    public static String longestWord(String sen) {
        sen = sen.replaceAll("[^a-zA-Z]", " ");
        sen = sen.replaceAll("\\s+", " ");
        String[] strArray = sen.split("\\s");
        String longestWord = "";
        int longestIndex = 0;
        for (String word : strArray) {
            if (word.length() > longestIndex) {
                longestWord = word;
                longestIndex = word.length();
            }
        }
        return longestWord;
    }

    public static void main(String[] args) {
        String s = "I love dogs";
        System.out.print(longestWord(s));

    }
}
