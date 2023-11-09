package com.binarysearch;

public class OrderAgnosticSearch {

    static int solve(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        int element1 = arr[0];
        int element2 = arr[1];
        if (arr.length == 1)
            return 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (element1 < element2) {
                if (element == arr[mid])
                    return mid;
                else if (element < arr[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (element == arr[mid])
                    return mid;
                else if (element < arr[mid])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {20, 10, 5, 4, 2};
        int element = 4;
        System.out.println(solve(arr, element));
    }
}
