package com.heap;

public class HeapImpl {

    static void maxHeapify(int[] arr, int i, int N) {
        int leftChildIndex = 2 * i + 1;
        int rightChildIndex = 2 * i + 2;
        int largestIndex = i;
        if (leftChildIndex <= N && arr[leftChildIndex] > arr[i])
            largestIndex = leftChildIndex;
        if (rightChildIndex <= N && arr[rightChildIndex] > arr[i])
            largestIndex = rightChildIndex;
        if (largestIndex != i) {
            int temp = arr[i];
            arr[i] = arr[largestIndex];
            arr[largestIndex] = temp;
            maxHeapify(arr, largestIndex, N);
        }
    }

    static void buildMaxHeap(int[] arr, int N) {
        int indexOfLastNonLeafNode = (N / 2) - 1;
        for (int i = indexOfLastNonLeafNode; i >= 0; i--) {
            maxHeapify(arr, i, N);
        }
    }

    static void printHeap(int[] arr, int N) {
        System.out.println("Array representation of Heap is :");
        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");
    }

    // max priority queue based on max heap
    int maximum(int[] arr) {
        return arr[0];
    }


}
