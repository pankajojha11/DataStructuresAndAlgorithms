package com.binarysearch;

public class IndexOfAnExtraElement {

    static int solve(int[] a, int[] b, int n) {
        int start = 0;
        int end = n - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == b[mid])
                start = mid + 1;
            else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 6, 8, 9, 10, 12};
        int[] b = {2, 4, 6, 8, 10, 12};
        int n = a.length;
        System.out.println(solve(a, b, n));
    }

}
