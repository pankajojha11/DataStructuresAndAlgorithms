package com.binarysearch;

public class FindFirstIndexOf1InInfiniteBinarySortedArray {
    static int solve(int[] arr, int element) {
        int start = 0;
        int end = 1;
        int res = -1;
        while (element > arr[end]) {
            start = end;
            end = end * 2;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (element == arr[mid]) {
                res = mid;
                end = mid - 1;
            } else if (element > arr[mid])
                start = mid + 1;
            else if (element < arr[mid])
                end = mid - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 1, 1, 1};
        int element = 1;
        System.out.println(solve(arr, element));

    }


}
