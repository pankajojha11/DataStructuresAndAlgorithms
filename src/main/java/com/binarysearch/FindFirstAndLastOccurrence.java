package com.binarysearch;

public class FindFirstAndLastOccurrence {

    static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int lower = lowerBound(nums, target);
        int higher = upperBound(nums, target);
        result[0] = lower;
        result[1] = higher;
        return result;
    }

    static int lowerBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                res = mid;
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }
        return res;
    }

    static int upperBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                res = mid;
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 10, 10, 10, 20};
        int element = 10;
        System.out.println(searchRange(arr, element));
    }
}
