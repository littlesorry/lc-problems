package com.littlesorry.leetcode;

public class BiSearch {

    public static void main(String[] args) {
        System.out.println(">>>" + findPivot(new int[]{4,5,6,7,0,1,2}, 0, 6));
    }


    public static int findPivot(int[] nums, int low, int high) {
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

    public static int biSearch(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = nums[(low + high) / 2];
        if (mid < target) {
            return biSearch(nums, target, (low + high) / 2 + 1, high);
        } else if (mid > target) {
            return biSearch(nums, target, low, (low + high) / 2 - 1);
        } else {
            return (low + high) / 2;
        }
    }
}
