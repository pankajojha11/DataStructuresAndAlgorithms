package com.recursion;

import java.util.Arrays;
import java.util.List;

public class SortList {

    static List<Integer> sort(List<Integer> list) {
        // base condition
        if (list.size() == 1)
            return list;

        int temp = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        sort(list);
        insert(list, temp);
        return list;
    }

    static void insert(List<Integer> list, int temp) {
        if (list.size() == 0 || list.get(list.size() - 1) == temp) {
            list.add(temp);
            return;
        }
        int val = list.get(list.size() - 1);
        list.remove(val);
        insert(list, temp);
        list.add(val);
    }

    static void traverse(List<Integer> list) {
        for (Integer a : list) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 4, 1, 6, 7);
        list = sort(list);
        traverse(list);

    }
}
