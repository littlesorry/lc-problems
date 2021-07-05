package com.littlesorry.leetcode.p0055;

public class CanJump {

    /**
     * https://leetcode-cn.com/problems/jump-game/
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int[] maxSteps = new int[nums.length];
        maxSteps[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            int j = i - 1;
            if (maxSteps[j] <= j) {
                return false;
            }

            maxSteps[i] = Math.max(maxSteps[j], i + nums[i]);
            if (maxSteps[i] >= (nums.length - 1)) {
                return true;
            }
        }

        return maxSteps[0] >= (nums.length - 1);
    }
}
