package com.recursion;

public class Qus8 {

    static String letterChanges(String str) {
//        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
//        final String ALPHABET_UPPER = ALPHABET.toUpperCase();
//        final String VOWELS = "aeiou";
//        StringBuilder newStr = new StringBuilder("");
//
//        for (char c : str.toCharArray()) {
//            int index = ALPHABET.indexOf(c);
//            if (index > -1) {
//                char newChar = index < ALPHABET.length() - 1 ? ALPHABET.charAt(index + 1) : 'a';
//                if (VOWELS.indexOf(newChar) > -1) {
//                    newChar = Character.toUpperCase(newChar);
//                }
//                newStr.append(newChar);
//            } else {
//                index = ALPHABET_UPPER.indexOf(c);
//                if (index > -1) {
//                    char newChar = index < ALPHABET_UPPER.length() - 1 ? ALPHABET_UPPER.charAt(index + 1) : 'A';
//                    newStr.append(newChar);
//                } else {
//                    newStr.append(c);
//                }
//            }
//        }
//        return newStr.toString();
        char[] alphabet = {'b', 'c', 'd', 'E', 'f', 'g', 'h', 'I', 'j', 'k', 'l',
                'm', 'n', 'O', 'p', 'q', 'r', 's', 't', 'U', 'v', 'w', 'x', 'y', 'z', 'A'};
        char[] charArray = str.toLowerCase().toCharArray();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            boolean isLetter = letter >= 'a' && letter <= 'z';
            if (isLetter) {
                output.append(alphabet[charArray[i] - 97]);
            } else {
                output.append(letter);
            }
        }

        return output.toString();

    }

    public static void main(String[] args) {
        String s = "hello3";
        System.out.println(letterChanges(s));
    }
}
