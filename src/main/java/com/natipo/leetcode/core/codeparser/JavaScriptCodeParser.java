package com.natipo.leetcode.core.codeparser;

public class JavaScriptCodeParser extends CodeParser {

    @Override
    public String getFileExtension() {
        return CodeLang.JAVASCRIPT.getFileExtension();
    }

    @Override
    String getClassNameRegex() {
        return "^var\\s(.*)\\s=\\sfunction\\(.*$";
    }
}
