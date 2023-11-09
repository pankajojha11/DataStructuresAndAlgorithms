package com.sliingwindow;

import java.util.ArrayList;
import java.util.List;

public class MaximumOfAllSubarrayOfSizeK {

    private static List<Integer> maximumOfAllSubarrayOfSizeK(int[] arr, int k) {
        int i = 0, j = 0;
        int max = 0;
        List<Integer> responseList = new ArrayList<>();
        while (j < arr.length) {
            // calculation
            max = Math.max(arr[j], max);
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                // get the ans from calculation
                responseList.add(max);
                // remove ith value

                // increment j and i
                j++;
                i++;
            }

        }
        return responseList;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(maximumOfAllSubarrayOfSizeK(arr, k));
    }


}
