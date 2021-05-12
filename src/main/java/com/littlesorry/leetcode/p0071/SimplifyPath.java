package com.littlesorry.leetcode.p0071;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] tokens = path.split("/");
        for (String token : tokens) {
            if (".".equals(token) || token.length() == 0){
                // do nothing
            } else if ("..".equals(token)) {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else {
                stack.push(token);
            }
        }

        if (stack.size() == 0) {
            return "/";
        }

        String result = "";
        for (String token : stack) {
            result = result + "/" + token;
        }

        return result;
    }

}
