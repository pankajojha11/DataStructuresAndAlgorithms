package com.sheet.string;

public class LongestRepeatingCharacterReplacement {

    private static int characterReplacement(String s, int k) {
        int i = 0, j = 0;
        int maxSize = 0;
        int[] char_counts = new int[26];

        while (j < s.length()) {
            // calculation
            char_counts[s.charAt(j) - 'A']++;
            j++;
            if ((j - i + 1) - maxSize < k) {
                // ans from calculation
                maxSize = Math.max(maxSize, char_counts[s.charAt(j) - 'A']);
                j++;
            } else if ((j - i + 1) - maxSize > k) {
                while ((j - i + 1) - maxSize > k) {
                    char_counts[s.charAt(i) - 'A']--;
                    i++;
                }
                j++;
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }


}
