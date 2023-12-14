package com.heap;

import java.util.PriorityQueue;

public class KClosestNumbers {
    private static void solve(int[] arr, int k, int x) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Math.abs(b - x) - Math.abs(a - x));
        for(int i = 0; i < arr.length; i++)
        {
//            maxHeap.add(Math.abs(arr[i] - x),arr[i]);
//            if(maxHeap.size() > 0)

        }
    }
    public static void main(String[] args) {
        int[] arr ={5,6,7,8,9};
        int k = 3;
        int x = 7;
        solve(arr,k,x);
    }


}
