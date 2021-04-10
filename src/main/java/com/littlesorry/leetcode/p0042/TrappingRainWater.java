package com.littlesorry.leetcode.p0042;

public class TrappingRainWater {

    public int trap(int[] height) {
        int trap = 0, minHeight = 0;
        int left = 0, right = height.length - 1, index = 0;

        while (left < right - 1) {
            if (height[left] > minHeight && height[right] > minHeight) {
                minHeight = height[left] < height[right] ? height[left] : height[right];
            }

            if (height[left] < height[right]) {
                index = ++left;
            } else {
                index = --right;
            }

            trap += (height[index] < minHeight ? minHeight - height[index] : 0);
        }

        return trap;
    }
}
