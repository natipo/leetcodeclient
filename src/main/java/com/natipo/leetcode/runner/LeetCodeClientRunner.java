package com.natipo.leetcode.runner;

import com.natipo.leetcode.core.CodeSnippetWriter;
import com.natipo.leetcode.core.LeetCodeClient;
import com.natipo.leetcode.model.CodeSnippet;
import com.natipo.leetcode.model.GraphqlRequest;
import com.natipo.leetcode.model.QuestionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class LeetCodeClientRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeetCodeClientRunner.class);

    @Autowired
    private LeetCodeClient client;

    @Autowired
    private CodeSnippetWriter codeSnippetWriter;

    @Value("${leetcode.problemId}")
    private String problemId;


    @Value("${leetcode.output.lang}")
    private String outputLang;

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Looking for problem: {}, lang: {}", problemId, outputLang);

        GraphqlRequest request = buildGraphqlRequest(problemId);
        QuestionResponse response = client.getResponse(request, QuestionResponse.class).getBody();

        handleResponse(response);
    }

    private GraphqlRequest buildGraphqlRequest(String problemId) {
        GraphqlRequest request = new GraphqlRequest();

        request.setOperationName("questionData");
        request.setQuery("query questionData($titleSlug: String!) { question(titleSlug: $titleSlug) { codeSnippets { lang langSlug code } } }");
        request.addVariable("titleSlug", problemId);

        return request;
    }

    private void handleResponse(QuestionResponse response) throws IOException {
        Optional<CodeSnippet> codeSnippet = response.getData().getQuestion().getCodeByLang(outputLang);

        if (codeSnippet.isPresent()) {
            LOGGER.info(codeSnippet.get().getCode());
            codeSnippetWriter.writeToFile(problemId, codeSnippet.get());
        } else {
            LOGGER.info("Not found");
        }
    }

}
