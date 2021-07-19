package com.littlesorry.leetcode.p0114;

import com.littlesorry.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {

    /**
     * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        List<TreeNode> nodes = new ArrayList<>();
        flatten0(root, nodes);

        TreeNode prev = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            prev.left = null;
            prev.right = nodes.get(i);
            prev = nodes.get(i);
        }
    }

    public void flatten0(TreeNode node, List<TreeNode> nodes) {
        if (node == null) {
            return;
        }

        nodes.add(node);
        flatten0(node.left, nodes);
        flatten0(node.right, nodes);
    }
}
