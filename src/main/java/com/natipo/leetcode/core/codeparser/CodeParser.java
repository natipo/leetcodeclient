package com.natipo.leetcode.core.codeparser;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class CodeParser {

    public String findClassName(String code) {
        Pattern regex = Pattern.compile(getClassNameRegex(), Pattern.MULTILINE);
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

    public abstract String getFileExtension();

    abstract String getClassNameRegex();
}
