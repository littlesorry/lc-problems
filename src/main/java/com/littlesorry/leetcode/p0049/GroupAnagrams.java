package com.littlesorry.leetcode.p0049;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Stream.of(strs).collect(Collectors.groupingBy(s -> toBits(s))).values());
    }

    private String toBits(String string) {
        if (string == null) {
            return "";
        }

        char[] result = new char[26];
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            result[c - 'a']++;
        }

        return new String(result);
    }
}
