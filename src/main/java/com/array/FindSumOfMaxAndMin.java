package com.array;

public class FindSumOfMaxAndMin {
    private static int findSum(int A[], int N) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < min)
                min = A[i];
            if (A[i] > max)
                max = A[i];
        }
        return max + min;
    }

    public static void main(String[] args) {
        int arr[] = {3, 5, 4, 1, 9};
        System.out.println(findSum(arr, arr.length));
    }
}
