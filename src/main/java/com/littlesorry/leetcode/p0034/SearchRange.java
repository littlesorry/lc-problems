package com.littlesorry.leetcode.p0034;

public class SearchRange {

    public static void main(String[] args) {
        System.out.println(new SearchRange().searchLeft(new int[]{5,7,7,8,8,10}, 8, 0, 5));
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchLeft(nums, target, 0, nums.length - 1)
                , searchRight(nums, target, 0, nums.length - 1)};
    }

    public int searchLeft(int[] nums, int target, int left, int right) {
        if (left == right) {
            return nums[left] == target ? left : -1;
        }

        if (nums[(right + left) / 2] > target) {
            return searchLeft(nums, target, left, (right + left) / 2);
        }

        return searchLeft(nums, target, (right + left) / 2, right);
    }

    public int searchRight(int[] nums, int target, int left, int right) {
        if (left == right) {
            return nums[left] == target ? left : -1;
        }

        if (nums[(right + left) / 2] < target) {
            return searchRight(nums, target, (right + left) / 2, right);
        }

        return searchRight(nums, target, left, (right + left) / 2);
    }
}
