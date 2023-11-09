package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class Qus7 {


    private static String common(String[] s) {
        String[] str1 = s[0].split(", ");
        String[] str2 = s[1].split(", ");
        List<String> commonList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < str1.length && j < str2.length) {
            int num1 = Integer.parseInt(str1[i]);
            int num2 = Integer.parseInt(str2[j]);
            if (num1 == num2) {
                commonList.add(Integer.toString(num1));
                i++;
                j++;
            } else if (num1 < num2) {
                i++;
            } else {
                j++;
            }
        }
        return commonList.isEmpty() ? "false" : String.join(",", commonList);

    }

    public static void main(String[] args) {
        String[] s = new String[]{"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
        System.out.println(common(s));
    }


}
