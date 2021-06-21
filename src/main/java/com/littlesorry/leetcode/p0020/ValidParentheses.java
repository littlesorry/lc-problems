package com.littlesorry.leetcode.p0020;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("(){}[]"));
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> path = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')' || c == ']' || c == '}') {
                if (path.isEmpty()) {
                    return false;
                }

                char previous = path.pop();
                if ((c - previous) > 2 || (c - previous) < -2) {
                    return false;
                }
            } else {
                path.push(c);
            }
        }

        return path.isEmpty();
    }
}
