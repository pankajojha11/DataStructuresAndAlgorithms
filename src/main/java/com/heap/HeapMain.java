package com.heap;

public class HeapMain {
    public static void main(String[] args) {
        int[] arr = {4, 7, 8, 3, 2, 6, 5};
        int N = arr.length;
        HeapImpl heapImpl = new HeapImpl();
        heapImpl.buildMaxHeap(arr, N);
        heapImpl.printHeap(arr, N);
        System.out.println("--------------------------------");
    }
}
