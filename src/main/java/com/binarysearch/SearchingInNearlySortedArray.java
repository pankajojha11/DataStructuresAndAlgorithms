package com.binarysearch;

public class SearchingInNearlySortedArray {

    static int solve(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (element == arr[mid])
                return mid;
            else if (mid - 1 >= start && arr[mid - 1] == element)
                return mid - 1;
            else if (mid + 1 <= end && arr[mid + 1] == element)
                return mid + 1;
            else if (element < arr[mid])
                end = mid - 2;
            else
                start = mid + 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 3, 40, 20, 50, 80, 70};
        int element = 40;
        System.out.println(solve(arr, element));
    }


}
