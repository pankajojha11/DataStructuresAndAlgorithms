package com.sheet.string;

public class RemoveConsecutiveCharacters {
    public static String removeConsecutiveCharacter(String S) {
        String res = "";
        for (int i = 0; i < S.length(); i++) {
            if (i < S.length() - 1 && S.charAt(i) == S.charAt(i + 1))
                continue;
            else
                res += S.charAt(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(removeConsecutiveCharacter(s));
    }

}
