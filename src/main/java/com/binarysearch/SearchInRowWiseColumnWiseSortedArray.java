package com.binarysearch;

public class SearchInRowWiseColumnWiseSortedArray {

    private static int[] solve(int[][] arr, int size, int element) {
        int[] res = new int[2];
        int i = 0;
        int j = size - 1;
        while (i >= 0 && i < size && j >= 0 && j < size) {
            if (arr[i][j] == element) {
                res[0] = i;
                res[1] = j;
                return res;
            } else if (arr[i][j] > element)
                j--;
            else if (arr[i][j] < element)
                i++;
        }
        res[0] = -1;
        res[1] = -1;
        return res;
    }


    public static void main(String[] args) {

        int mat[][] = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
        int[] arr = solve(mat, 4, 29);
        System.out.println(arr[0] + " " + arr[1]);
    }
}
