package com.binarysearch;

public class NextAlphabeticalElement {
    static char nextGreatestAlphabet(char[] letters, char element) {
        int start = 0;
        int end = letters.length - 1;
        char res = '#';
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (element == letters[mid])
                start = mid + 1;
            else if (element < letters[mid]) {
                res = letters[mid];
                end = mid - 1;
            } else if (element > letters[mid]) {
                start = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[] letters = {'A', 'r', 'z'};
        char element = 'r';
        System.out.println(nextGreatestAlphabet(letters, element));
    }


}
