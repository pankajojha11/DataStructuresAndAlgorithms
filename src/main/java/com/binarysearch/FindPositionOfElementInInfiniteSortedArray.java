package com.binarysearch;

public class FindPositionOfElementInInfiniteSortedArray {
    static int solve(int[] arr, int element) {
        int start = 0;
        int end = 1;
        while (element > arr[end]) {
            start = end;
            end *= 2;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (element == arr[mid])
                return mid;
            else if (element > arr[mid])
                start = mid + 1;
            else if (element < arr[mid])
                end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int element = 10;
        System.out.println(solve(arr, element));
    }


}
