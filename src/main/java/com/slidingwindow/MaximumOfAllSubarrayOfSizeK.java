package com.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class MaximumOfAllSubarrayOfSizeK {

    private static List<Integer> maximumOfAllSubarrayOfSizeK(int[] arr, int k) {
        int i = 0;
        int j = 0;
        List<Integer> maxList = new ArrayList<>();
        List<Integer> responseList = new ArrayList<>();

        while (j < arr.length) {
            // calculation
            while (maxList.size() > 0 && maxList.get(maxList.size() - 1) < arr[j]) {
                maxList.remove(maxList.size() - 1);
            }
            maxList.add(arr[j]);
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                // ans from calculation
                responseList.add(maxList.get(0));
                // slide the window remove ith value
                if (maxList.get(0) == arr[i])
                    maxList.remove(0);
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
