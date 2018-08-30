package com.littlesorry.leetcode.p032;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * <p>
 * User: baofeng.wbf
 * Date: 2018-08-30
 * Time: 下午5:15
 */
public class LongestValidParentheses {


    public int longestValidParentheses(String s) {
        final char[] chars = s.toCharArray();
        int result = 0, current = 0, balance = 0;
        for (int i = 0; i < chars.length; i++) {
            current++;
            if (chars[i] == '(') {
                balance++;
            } else {
                balance--;
                if (balance == 0 && current > result) {
                    result = current;
                } else if (balance < 0) {
                    current = 0;
                    balance = 0;
                }
            }
        }

        current = 0;
        balance = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            current++;
            if (chars[i] == ')') {
                balance++;
            } else {
                balance--;
                if (balance == 0 && current > result) {
                    result = current;
                } else if (balance < 0) {
                    current = 0;
                    balance = 0;
                }
            }
        }

        return result;
    }



}
