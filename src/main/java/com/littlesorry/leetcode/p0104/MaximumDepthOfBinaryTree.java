package com.littlesorry.leetcode.p0104;

import com.littlesorry.leetcode.TreeNode;

public class MaximumDepthOfBinaryTree {

    /**
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDeps = maxDepth(root.left);
        int rightDeps = maxDepth(root.right);

        return Math.max(leftDeps, rightDeps) + 1;
    }
}
