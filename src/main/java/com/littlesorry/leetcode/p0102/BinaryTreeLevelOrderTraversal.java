package com.littlesorry.leetcode.p0102;

import com.littlesorry.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result
                = new ArrayList<>();
        List<TreeNode> layer = new ArrayList<>();
        layer.add(root);

        while(!layer.isEmpty()) {
            ArrayList<Integer> values = new ArrayList<>();
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode node : layer) {
                values.add(node.val);

                if (node.left != null) {
                    next.add(node.left);
                }

                if (node.right != null) {
                    next.add(node.right);
                }
            }

            result.add(values);
            layer = next;
        }

        return result;
    }
}
