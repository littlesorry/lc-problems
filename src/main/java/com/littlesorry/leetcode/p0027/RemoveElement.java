package com.littlesorry.leetcode.p0027;

public class RemoveElement {

    /**
     * https://leetcode-cn.com/problems/remove-element/
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[idx++] = nums[i];
            }
        }

        return idx;
    }
}
