package com.natipo.leetcode.core.codeparser;

public enum CodeLang {

    CPP("cpp"),
    PYTHON("py"),
    PYTHON3("py3"),
    C("c"),
    CSHARP("cs"),
    JAVASCRIPT("js"),
    RUBY("rb"),
    SWIFT(""),
    GO("go"),
    SCALA(""),
    KOTLIN(""),
    RUST(""),
    PHP("php"),
    JAVA("java");

    private String ext;

    CodeLang(String ext) {
        this.ext = ext;
    }

    public String getFileExtension() {
        return ext;
    }
}
