package com.natipo.leetcode.model;

import java.util.List;
import java.util.Optional;

public class Question {

    private List<CodeSnippet> codeSnippets;

    public List<CodeSnippet> getCodeSnippets() {
        return codeSnippets;
    }

    public void setCodeSnippets(List<CodeSnippet> codeSnippets) {
        this.codeSnippets = codeSnippets;
    }

    public Optional<CodeSnippet> getCodeByLang(final String lang) {
        return codeSnippets.stream().filter(code -> code.getLangSlug().equalsIgnoreCase(lang)).findFirst();
    }
}
