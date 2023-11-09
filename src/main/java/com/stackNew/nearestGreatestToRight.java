package com.stackNew;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class nearestGreatestToRight {
    static void nearestGreatest(int[] arr, int n) {
        int next = -1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; i < n; j++) {
                if (arr[i] < arr[j]) {
                    next = arr[j];
                    break;
                }
            }
            System.out.println(arr[i] + " -- " + next);
        }
        System.out.println(arr[n - 1] + " -- " + "-1");
    }

    static List<Integer> nearestGreatestWithStack(int[] arr, int n) {
        List<Integer> listOfNearestGreatest = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (stack.size() == 0)
                listOfNearestGreatest.add(0, -1);
            if (stack.size() > 0 && stack.peek() > arr[i])
                listOfNearestGreatest.add(0, stack.peek());
            else if (stack.size() > 0 && stack.peek() <= arr[i]) {
                while (stack.size() > 0 && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.size() == 0)
                    listOfNearestGreatest.add(0, -1);
                else if (stack.size() > 0 && stack.peek() > arr[i])
                    listOfNearestGreatest.add(0, stack.peek());
            }
            stack.push(arr[i]);
        }
        return listOfNearestGreatest;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        int n = arr.length;
        nearestGreatest(arr, n);
        System.out.println(nearestGreatestWithStack(arr, n));
    }


}
