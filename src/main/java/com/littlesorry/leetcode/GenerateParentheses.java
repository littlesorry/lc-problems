package com.littlesorry.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by baofeng.wbf on 2016-05-03 5:59 PM.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n < 1) return new ArrayList<>();

        List<String> result = new LinkedList<>();
        generate(result, "(", 2 * n - 1, -1);

        return result;
    }

    public void generate(List<String> result, String prefix, int n, int target) {
        if (target < 0 && -target > n) return;
        if ((target % 2 + 2) % 2 != n % 2) return;

        if (n == 0 && target == 0) {
            result.add(prefix);
            return;
        }

        if (n == 0) return;

        generate(result, prefix + "(", n - 1, target - 1);
        if (target < 0) generate(result, prefix + ")", n - 1, target + 1);
    }
}
