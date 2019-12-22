package com.natipo.leetcode.core;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class JavaCodeParser {

    public String findClassName(String code) {
        Pattern regex = Pattern.compile("^class\\s(.*)\\s\\{", Pattern.MULTILINE);
        Matcher regexMatcher = regex.matcher(code);
        if (regexMatcher.find()) {
            return regexMatcher.group(1);
        } else {
            return "Solution";
        }
    }

    public List<String> getLines(String code) {
        return Arrays.asList(code.split("\\r?\\n"));
    }
}
