package com.array;

class Pair {
    long first, second;

    public Pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}

public class MinimumMaximumOfAnArrayUsingMinimumNumberOfComparisons {
    private static Pair getMinMax(int[] arr) {

        Pair pair = new Pair(arr[0], arr[0]);
        long max = arr[0];
        long min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        pair.first = max;
        pair.second = min;
        return pair;
    }

    public static void main(String[] args) {
        int arr[] = {3, 5, 4, 1, 9};
        System.out.println(getMinMax(arr));
    }
}
