package com.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortKSortedArray {
    private static void solve(int[] arr, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            minheap.add(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 2, 3, 6};
        int k = 3;
        // k and smallest or largets ---> Heap ---> priority queue by default in java minheap
        solve(arr, k); // 6 5 4
    }


}
