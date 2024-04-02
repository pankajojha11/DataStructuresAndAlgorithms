package com.binarysearch;

public class FindElementInRotatedSortedArray {

    static int solve(int[] arr, int element) {
        int index = findMinimumElement(arr);
        return Math.max(binarySearch(arr, element, 0, index - 1), binarySearch(arr, element, index, arr.length - 1));
    }

    // finding the minimum element  is equals to no of rotations of the array
    static int findMinimumElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int res = -1;
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
        return res;
    }

    static int binarySearch(int[] arr, int element, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (element == arr[mid])
                return mid;
            else if (element < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {7, 9, 11, 12, 5, 6};
        int element = 5;
        System.out.println(solve(arr, element));
    }


}
