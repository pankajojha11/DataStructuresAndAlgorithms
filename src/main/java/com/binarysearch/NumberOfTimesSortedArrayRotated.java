package com.binarysearch;

public class NumberOfTimesSortedArrayRotated {

    static int solve(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int next = (mid + 1) % arr.length;
            int prev = (mid + arr.length - 1) % arr.length;
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev])
                return mid;
            if (arr[start] <= arr[mid])
                start = mid + 1;
            else if (arr[mid] <= arr[end])
                end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {7, 9, 11, 12, 5};
        System.out.println(solve(arr));
    }


}
