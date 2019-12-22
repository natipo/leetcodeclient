package com.natipo.leetcode.core.codeparser;

public class CsharpCodeParser extends CodeParser {

    @Override
    public String getFileExtension() {
        return CodeLang.CSHARP.getFileExtension();
    }

    @Override
    String getClassNameRegex() {
        return "^public class\\s(.*)\\s\\{";
    }
}
