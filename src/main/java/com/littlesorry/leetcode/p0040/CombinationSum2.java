package com.littlesorry.leetcode.p0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (target < candidates[i]) {
                return;
            }

            path.add(candidates[i]);
            combination(answers, path, candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }
}
