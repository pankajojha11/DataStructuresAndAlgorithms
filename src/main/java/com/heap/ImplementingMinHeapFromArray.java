package com.heap;

public class ImplementingMinHeapFromArray {

    private static void minHeapify(int[] arr, int i, int N) {
        int leftChildIndex = 2 * i + 1;
        int rightChildIndex = 2 * i + 2;
        int smallestIndex = i;
        if (leftChildIndex <= N && arr[leftChildIndex] < arr[smallestIndex])
            smallestIndex = leftChildIndex;
        if (rightChildIndex <= N && arr[rightChildIndex] < arr[smallestIndex])
            smallestIndex = rightChildIndex;
        if (smallestIndex != i) {
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
            minHeapify(arr, smallestIndex, N);
        }
    }

    private static void buildMinHeap(int[] arr, int N) {
        int indexOfLastNonLeafNode = (N / 2) - 1;
        for (int i = indexOfLastNonLeafNode; i >= 0; i--) {
            minHeapify(arr, i, N);
        }
    }

    static void printHeap(int[] arr, int N) {
        System.out.println("Array representation of Heap is :");
        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 8, 3, 2, 6, 5};
        int N = arr.length;
        buildMinHeap(arr, N);
        printHeap(arr, N);
    }
}
