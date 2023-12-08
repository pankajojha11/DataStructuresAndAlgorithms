package com.slidingwindownew;

import java.util.ArrayList;
import java.util.List;

public class MaximumOfAllSubarrayOfSizeK {

    private static List<Integer> maximumOfAllSubarrayOfSizeK(int[] arr, int k) {
        int i = 0;
        int j = 0;
        List<Integer> responseList = new ArrayList<>();
        List<Integer> maxList = new ArrayList<>();
        while (j < arr.length) {
            // calculations
            while (maxList.size() > 0 && maxList.get(maxList.size() - 1) < arr[j]) {
                maxList.remove(maxList.size() - 1);
            }
            maxList.add(arr[j]);
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                // get ans from calculations
                responseList.add(maxList.get(0));
                // remove ith value slide window
                if (arr[i] == maxList.get(0)) {
                    maxList.remove(0);
                }
                i++;
                j++;
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
