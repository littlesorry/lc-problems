package com.littlesorry.leetcode;

/**
 * Created by baofeng.wbf on 2016-05-03 5:57 PM.
 */
public class SortColor {

    public void sortColors(int[] nums) {
        int i = 0, j = 0;
        int[] count = new int[] {0, 0, 0};
        for (int idx = nums.length - 1; idx >= 0; idx--) {
            count[nums[idx]] += 1;
        }

        for (int idx = nums.length - 1; idx >= 0; idx--) {
            if (idx > count[0] + count[1] - 1) {
                nums[idx] = 2;
            } else if (idx > count[0] - 1) {
                nums[idx] = 1;
            } else {
                nums[idx] = 0;
            }
        }
    }
}
