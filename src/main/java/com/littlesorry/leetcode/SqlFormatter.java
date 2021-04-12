package com.littlesorry.leetcode;

import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;

public class SqlFormatter {

    public static void main(String[] args) {
        String tpl = "truncate table ka_volume_index_{0};";

        for (int i = 0; i < 100; i++) {
            System.out.println(MessageFormat.format(tpl, StringUtils.leftPad("" + i, 3, "0")));
        }

    }
}
