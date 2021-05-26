package com.littlesorry.leetcode.p0113;

import com.littlesorry.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return pathSum0(root, new ArrayList<>(), 0, targetSum);
    }

    public List<List<Integer>> pathSum0(TreeNode node, List<Integer> path, int prev, int target) {
        if (node == null) {
            return Collections.emptyList();
        }

        int remaining = target - prev;
        if (node.left == null && node.right == null && node.val == remaining) {
            List<Integer> answer = new ArrayList<>(path);
            answer.add(node.val);

            return Arrays.asList(answer);
        } else {
            path.add(node.val);

            List<List<Integer>> result = new ArrayList<>();
            result.addAll(pathSum0(node.left, path, prev + node.val, target));
            result.addAll(pathSum0(node.right, path, prev + node.val, target));

            path.remove(path.size() - 1);
            return result;
        }
    }
}
