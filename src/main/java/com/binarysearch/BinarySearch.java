package com.binarysearch;

public class BinarySearch {

    // find element index
    static int solve(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
//            int mid = start + end / 2;
            int mid = start + (end - start) / 2;// for int overflow optimization
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
        int[] arr = {1, 2, 3, 4, 5};
        int element = 2;
        System.out.println(solve(arr, element));
    }


}
