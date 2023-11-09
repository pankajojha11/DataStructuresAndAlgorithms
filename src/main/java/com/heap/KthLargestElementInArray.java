package com.heap;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

    private static void largestElement(int[] arr, int k) {
        // min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (minHeap.peek() < arr[i]) {
                minHeap.remove();
                minHeap.add(arr[i]);
            }
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
        largestElement(arr, k); // 6 5 4
    }
}
