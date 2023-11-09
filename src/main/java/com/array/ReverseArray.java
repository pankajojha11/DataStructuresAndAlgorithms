package com.array;

public class ReverseArray {

    // linear traversing reverse way
    private static void reverseArray(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    // reverse array by using two pointer
    private static void reverseArrayByTwoPointer(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        traverse(arr);
    }

    // reverse array by recursion
    private static void reverseArrayByRecursion(int[] arr, int start, int end) {
        // base case
        if (start >= end)
            return;
        // implementation
        int temp;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArrayByRecursion(arr, ++start, --end);
    }

    // traverse the array from index 0
    private static void traverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] arg) {
        int[] arr = {1, 2, 3};
        reverseArray(arr);
        reverseArrayByTwoPointer(arr);
        reverseArrayByRecursion(arr, 0, arr.length - 1);
        traverse(arr);
    }

}
