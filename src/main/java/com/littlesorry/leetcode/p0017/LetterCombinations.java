package com.littlesorry.leetcode.p0017;

import java.util.*;

public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> numbers = new HashMap<>();
        numbers.put('2', Arrays.asList("a", "b", "c"));
        numbers.put('3', Arrays.asList("d", "e", "f"));
        numbers.put('4', Arrays.asList("g", "h", "i"));
        numbers.put('5', Arrays.asList("j", "k", "l"));
        numbers.put('6', Arrays.asList("m", "n", "o"));
        numbers.put('7', Arrays.asList("p", "q", "r", "s"));
        numbers.put('8', Arrays.asList("t", "u", "v"));
        numbers.put('9', Arrays.asList("w", "x", "y", "z"));

        List<String> result = new ArrayList<>();
        for (int i = digits.length() - 1; i >= 0; i--) {
            Character c = digits.charAt(i);
            result = expand(numbers.get(c), result);
        }

        return result;
    }

    public List<String> expand(List<String> current, List<String> previous) {
        if (previous.isEmpty()) {
            return current;
        }

        List<String> result = new ArrayList<>();
        for (String cur : current) {
            for (String pre : previous) {
                result.add(cur + pre);
            }
        }

        return result;
    }
}
