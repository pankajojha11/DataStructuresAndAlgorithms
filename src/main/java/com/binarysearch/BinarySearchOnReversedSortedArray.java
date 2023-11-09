package com.binarysearch;

public class BinarySearchOnReversedSortedArray {
    static int solve(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (element == arr[mid])
                return mid;
            else if (element < arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {20, 10, 5, 4, 2};
        int element = 4;
        System.out.println(solve(arr, element));
    }


}
