package com.littlesorry.leetcode.p0048;

public class RotateImage {

    public void rotate(int[][] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            rotateAt(nums, i, (nums.length - 1) - i * 2);
        }
    }

    private void rotateAt(int[][] nums, int depth, int length) {
        int tmp;
        for (int i = 0; i < length; i++) {
            tmp = nums[depth + i][depth];

            nums[depth + i][depth] = nums[depth + length][depth + i];
            nums[depth + length][depth + i] = nums[depth + length - i][depth + length];
            nums[depth + length - i][depth + length] = nums[depth][depth + length - i];
            nums[depth][depth + length - i] = tmp;
        }
    }
}
