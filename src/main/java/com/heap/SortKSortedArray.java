package com.heap;

import java.util.PriorityQueue;

public class SortKSortedArray {

    private static void solve(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k) {
                System.out.print(minHeap.poll() + " ");
            }
        }
        while (minHeap.size() > 0) {
            System.out.print(minHeap.peek() + " ");
            minHeap.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 2, 3, 6};
        int k = 3;
        // k and smallest or largets ---> Heap ---> priority queue by default in java minheap
        solve(arr, k); // 6 5 4
    }


}
