package com.littlesorry.leetcode.p0039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        combination(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    public void combination(List<List<Integer>> answers, List<Integer> path, int[] candidates, int target, int start) {
        if (target == 0) {
            answers.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                path.add(candidates[i]);
                combination(answers, path, candidates, target - candidates[i], i);
                path.remove(path.size() - 1);
            }
        }
    }
}
