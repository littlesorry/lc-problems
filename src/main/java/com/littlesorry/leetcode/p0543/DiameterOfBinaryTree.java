package com.littlesorry.leetcode.p0543;

import com.littlesorry.leetcode.TreeNode;

public class DiameterOfBinaryTree {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTree0(root);
        return max;
    }

    public int diameterOfBinaryTree0(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = diameterOfBinaryTree0(node.left);
        int right = diameterOfBinaryTree0(node.right);

        if ((left + right) > max) {
            max = left + right;
        }

        return Math.max(left, right) + 1;
    }
}
