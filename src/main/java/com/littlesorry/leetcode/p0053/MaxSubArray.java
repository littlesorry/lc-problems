package com.littlesorry.leetcode.p0053;

public class MaxSubArray {

    /**
     * https://leetcode-cn.com/problems/maximum-subarray/
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] maxSeqSum = new int[nums.length];
        int max = maxSeqSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxSeqSum[i - 1] < 0) {
                maxSeqSum[i] = nums[i];
            } else {
                maxSeqSum[i] = maxSeqSum[i - 1] + nums[i];
            }

            if (maxSeqSum[i] > max) {
                max = maxSeqSum[i];
            }
        }

        return max;
    }
}
