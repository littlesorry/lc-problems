package com.littlesorry.leetcode.p0216;

import com.littlesorry.leetcode.p0039.CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public static void main(String[] args) {

        System.out.println(new CombinationSum3().combinationSum3(3, 7));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combination(result, new ArrayList<>(), k, n, 1);

        return result;
    }

    public void combination(List<List<Integer>> answers, List<Integer> path, int size, int target, int start) {
        if (target == 0 && size == 0) {
            answers.add(new ArrayList<>(path));
            return;
        }

        if (size > target || size == 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            path.add(i);
            combination(answers, path, size - 1, target - i, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
