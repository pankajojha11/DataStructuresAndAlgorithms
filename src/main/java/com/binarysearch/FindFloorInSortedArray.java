package com.binarysearch;

public class FindFloorInSortedArray {

    static int solve(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (element == arr[mid])
                return arr[mid];
            else if (element < arr[mid]) {
                end = mid - 1;
            } else if (element > arr[mid]) {
                res = arr[mid];
                start = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 9, 11, 12};
        int element = 10;
        System.out.println(solve(arr, element));
    }


}
