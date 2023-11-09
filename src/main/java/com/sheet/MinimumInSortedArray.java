package com.sheet;

public class MinimumInSortedArray {

    private static int minimumInSortedArray(int[] arr) {
        // linear search ---< O(n)
//        int result = arr[0];
//        for (Integer i : arr) {
//            if (i < result)
//                result = i;
//        }
//        return result;
        // binary search ---> searching and sorting
        int low = 0;
        int high = arr.length - 1;

        if (arr[low] <= arr[high]) {
            // sorted array
            return arr[0];
        }
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > arr[mid + 1])
                return arr[mid + 1];
            else if (arr[mid] < arr[mid - 1])
                return arr[mid];
            else if (arr[low] <= arr[mid])
                // that means low to mid is sorted and we will not get the result so low = mid + 1
                low = mid + 1;
            else if (arr[mid] <= arr[high])
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(minimumInSortedArray(arr));
    }

}
