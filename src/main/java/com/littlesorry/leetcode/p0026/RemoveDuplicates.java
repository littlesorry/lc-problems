package com.littlesorry.leetcode.p0026;

public class RemoveDuplicates {

    /**
     * my answer
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int offset = 0;
        int previous = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            if (current == previous) {
                offset ++;
            } else {
                nums[i - offset] = current;
            }

            previous = current;
        }

        return nums.length - offset;
    }

    /**
     * official
     *
     * @param nums
     * @return
     */
    public int removeDuplicatesOfficial(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
