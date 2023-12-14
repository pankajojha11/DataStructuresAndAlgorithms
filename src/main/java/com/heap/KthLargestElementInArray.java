package com.heap;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

    private static void KthLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k)
                minHeap.poll();
        }
        while (minHeap.size() > 0) {
            System.out.println(minHeap.peek());
            minHeap.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 2, 3, 6};
        int k = 3;
        // k and smallest or largets ---> Heap ---> priority queue by default in java minheap
        KthLargestElement(arr, k); // 6 5 4
    }
}
