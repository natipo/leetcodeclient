package com.natipo.leetcode.core;

import com.natipo.leetcode.core.codeparser.CodeParser;
import com.natipo.leetcode.model.CodeSnippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class CodeSnippetWriter {

    private final CodeParser codeParser;

    @Value("${leetcode.output.dir}")
    private String outputDir;

    @Autowired
    public CodeSnippetWriter(CodeParser codeParser) {
        this.codeParser = codeParser;
    }

    public void writeToFile(String problemId, CodeSnippet codeSnippet) throws IOException {
        String fileName = codeParser.findClassName(codeSnippet.getCode()) + "." + codeParser.getFileExtension();
        List<String> lines = codeParser.getLines(codeSnippet.getCode());
        Files.createDirectories(Paths.get(outputDir, problemId));
        Path file = Paths.get(outputDir, problemId, fileName);
        Files.write(file, lines, StandardCharsets.UTF_8);
    }
}
