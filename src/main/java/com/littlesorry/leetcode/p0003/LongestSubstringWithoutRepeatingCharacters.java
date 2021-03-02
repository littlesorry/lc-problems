package com.littlesorry.leetcode.p0003;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * <p>
 * User: baofeng.wbf
 * Date: 2018-08-30
 * Time: 下午4:18
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int current = 1;
            boolean[] charMap = new boolean[128];
            charMap[chars[i]] = true;

            for (int j = i + 1; j < chars.length; j++) {
                if (charMap[chars[j]]) {
                    break;
                }

                charMap[chars[j]] = true;
                current++;
            }

            if (current > result) result = current;
        }

        return result;
    }

    public int lengthOfLongestSubstringSlideWindow(String s) {
        int current = 0, result = 0, left = 0;
        int[] charMap = new int[128];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            current++;
            while (charMap[chars[i]] > 0) {
                charMap[chars[left]]--;
                current--;
                left++;
            }

            if (current > result) {
                result = current;
            }

            charMap[chars[i]]++;
        }

        return result;
    }
}
