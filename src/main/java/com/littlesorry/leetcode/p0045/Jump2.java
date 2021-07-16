package com.littlesorry.leetcode.p0045;

public class Jump2 {

    public static void main(String[] args) {

        System.out.println(new Jump2().jump(new int[5]));
    }

    public int jump(int[] nums) {
        int upbound = 0, range = 0, steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            upbound = Math.max(upbound, i + nums[i]);
            if (i == range && upbound > i) {
                range = upbound;
                steps++;
            }
        }

        return steps;
    }
}
