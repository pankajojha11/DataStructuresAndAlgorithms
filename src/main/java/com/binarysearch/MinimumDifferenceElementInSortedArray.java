package com.binarysearch;

public class MinimumDifferenceElementInSortedArray {
    static int solve(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (element == arr[mid])
                return arr[mid];
            else if (element > arr[mid])
                start = mid + 1;
            else if (element < arr[mid])
                end = mid - 1;
        }
        int leftHalfDiff = Math.abs(arr[end] - element);
        int rightHalfDiff = Math.abs(arr[start] - element);
        return leftHalfDiff > rightHalfDiff ? arr[start] : arr[end];
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 9, 12, 14};
        int element = 10;
        System.out.println(solve(arr, element));
    }


}
