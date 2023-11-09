package com.recursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PrintUniqueSubsets {
    static Map<String, Integer> solve(String ip, String op) {
        Map<String, Integer> uniqueSubset = new HashMap<>();
        if (ip.length() == 0) {
            uniqueSubset.put(op, uniqueSubset.getOrDefault(op, 1) + 1);
            return uniqueSubset;
        }
        String OP1 = op;
        String OP2 = op;
        OP2 += ip.charAt(0);
        ip = ip.substring(1);
        solve(ip, OP1);
        solve(ip, OP2);
        return uniqueSubset;
    }

    public static void main(String[] args) {
        String ip = "aab";
        String op = "";
        solve(ip, op);
    }


}
