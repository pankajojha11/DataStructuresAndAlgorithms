package com.binarysearch;

public class CountOccurrencesOfElement {

    static int solve(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        int firstOccurrence = -1;
        int lastOccurrence = -1;
        return findLastOccurrence(arr, start, end, element, lastOccurrence) - findFirstOccurrence(arr, start, end, element, firstOccurrence) + 1;
    }

    static int findFirstOccurrence(int[] arr, int start, int end, int element, int firstOccurrence) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (element == arr[mid]) {
                firstOccurrence = mid;
                end = mid - 1;
            } else if (element < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return firstOccurrence;
    }

    static int findLastOccurrence(int[] arr, int start, int end, int element, int lastOccurrence) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (element == arr[mid]) {
                lastOccurrence = mid;
                start = mid + 1;
            } else if (element < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return lastOccurrence;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 10, 10, 10, 20};
        int element = 10;
        System.out.println(solve(arr, element));
    }
}
