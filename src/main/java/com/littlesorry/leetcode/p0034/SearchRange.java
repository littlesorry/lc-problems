package com.littlesorry.leetcode.p0034;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int idx = search(nums, target, 0, nums.length - 1);
        return range(nums, idx);
    }

    public int search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (nums[mid] > target) {
            return search(nums, target, start, mid - 1);
        } else if (nums[mid] < target) {
            return search(nums, target, mid + 1, end);
        } else {
            // equals
            return mid;
        }
    }

    public int[] range(int[] nums, int idx) {

        if (idx == -1) {
            return new int[]{-1, -1};
        }

        int[] result = new int[]{idx, idx};
        for (int i = idx - 1; i >= 0; i--) {
            if (nums[i] == nums[idx]) {
                result[0] = i;
            } else {
                break;
            }
        }

        for (int i = idx + 1; i < nums.length; i++) {
            if (nums[i] == nums[idx]) {
                result[1] = i;
            } else {
                break;
            }
        }

        return result;
    }
}
