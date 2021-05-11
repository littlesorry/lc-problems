package com.littlesorry.leetcode.p0078;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        int total = 1 << nums.length;
        List<List<Integer>> result = new ArrayList<>(total);
        for (int i = 0; i < total; i++) {
            List<Integer> oneSet = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ( (i & (1 << j)) > 0) {
                    oneSet.add(nums[j]);
                }
            }

            result.add(oneSet);
        }

        return result;
    }

}
