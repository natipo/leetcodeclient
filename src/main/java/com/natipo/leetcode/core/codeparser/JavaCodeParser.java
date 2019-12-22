package com.natipo.leetcode.core.codeparser;

public class JavaCodeParser extends CodeParser {

    @Override
    public String getFileExtension() {
        return CodeLang.JAVA.getFileExtension();
    }

    @Override
    String getClassNameRegex() {
        return "^class\\s(.*)\\s\\{";
    }
}
