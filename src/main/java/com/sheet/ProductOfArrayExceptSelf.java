package com.sheet;

public class ProductOfArrayExceptSelf {

    private static int[] productOfArrayExceptSelf(int[] arr) {
        int n = arr.length;
        int[] prefixProductFromStart = new int[n], prefixProductFromEnd = new int[n], res = new int[n];
        prefixProductFromStart[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixProductFromStart[i] = prefixProductFromStart[i - 1] * arr[i];
        }
        prefixProductFromEnd[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            prefixProductFromEnd[i] = prefixProductFromEnd[i + 1] * arr[i];
        }
        res[0] = prefixProductFromEnd[1];
        res[n - 1] = prefixProductFromStart[n - 2];
        for (int i = 1; i < n - 1; i++) {
            res[i] = prefixProductFromStart[i - 1] * prefixProductFromEnd[i + 1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 0, 1, 3, 2};
        System.out.println(productOfArrayExceptSelf(arr));
    }


}
