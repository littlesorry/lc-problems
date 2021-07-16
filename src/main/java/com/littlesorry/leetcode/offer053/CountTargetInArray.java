package com.littlesorry.leetcode.offer053;

public class CountTargetInArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0
                || nums[0] > target
                || nums[nums.length - 1] < target)
            return 0;

        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return 0;
        }

        int mid = (start + end) / 2;
        if (nums[mid] > target) {
            return search(nums, target, start, mid - 1);
        } else if (nums[mid] < target) {
            return search(nums, target, mid + 1, end);
        } else {
            return count(nums, target, mid);
        }
    }

    public int count(int[] nums, int target, int idx) {
        int count = 1;
        for (int i = idx - 1; i >= 0; i--) {
            if (nums[i] != target) {
                break;
            }

            count++;
        }

        for (int i = idx + 1; i < nums.length; i++) {
            if (nums[i] != target) {
                break;
            }

            count++;
        }

        return count;
    }
}
