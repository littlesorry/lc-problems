package com.littlesorry.leetcode.p0033;

public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length - 1);
        pivot = pivot < 0 ? nums.length : pivot;

        if (target > nums[0]) {
            return biSearch(nums, target, 0, pivot -1);
        } else if (target < nums[0]) {
            return biSearch(nums, target, pivot, nums.length - 1);
        } else {
            return 0;
        }
    }

    public int findPivot(int[] nums, int low, int high) {
        if (low >= high) return -1;
        if ((high - low) == 1 && nums[low] > nums[high]) return high;

        int mid = (low + high) / 2;
        if (nums[low] > nums[mid]) {
            return findPivot(nums, low, mid);
        } else if (nums[mid] > nums[high]) {
            return findPivot(nums, mid, high);
        }

        return -1;
    }

    public int biSearch(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (nums[mid] < target) {
            return biSearch(nums, target, (low + high) / 2 + 1, high);
        } else if (nums[mid] > target) {
            return biSearch(nums, target, low, (low + high) / 2 - 1);
        } else {
            return mid;
        }
    }

}
