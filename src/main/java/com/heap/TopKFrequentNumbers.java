package com.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentNumbers {

    private static void topKFrequentNumbers(int[] arr, int k) {
        Map<Integer, Integer> countOfDigitOccurrence = new HashMap<>();
        for (Integer i : arr) {
            countOfDigitOccurrence.put(i, countOfDigitOccurrence.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(countOfDigitOccurrence::get));
        for (Integer i : countOfDigitOccurrence.keySet()) {
            minHeap.add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 2, 2, 4};
        int k = 2;
        topKFrequentNumbers(arr, k);
    }

}
