package com.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeNumberInEveryWindowOfSizeK {

    private static List<Integer> firstNegativeNumberInEveryWindowOfSizeK(int[] arr, int k) {
        int i = 0;
        int j = 0;
        List<Integer> negativeNumberList = new ArrayList<>();
        List<Integer> responseList = new ArrayList<>();

        while (j < arr.length) {
            // calculation
            if (arr[j] < 0)
                negativeNumberList.add(arr[j]);
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                // ans from calculation
                if (negativeNumberList.isEmpty())
                    responseList.add(0);
                else {
                    responseList.add(negativeNumberList.get(0));
                    // slide the window
                    if (arr[i] == negativeNumberList.get(0))
                        negativeNumberList.remove(0);
                }
                i++;
                j++;
            }
        }
        return responseList;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 5, 0, -8, 3};
        int k = 3;
        System.out.println(firstNegativeNumberInEveryWindowOfSizeK(arr, k));
    }


}
