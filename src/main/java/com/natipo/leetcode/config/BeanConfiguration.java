package com.natipo.leetcode.config;

import com.natipo.leetcode.core.codeparser.CodeLang;
import com.natipo.leetcode.core.codeparser.CodeParser;
import com.natipo.leetcode.core.codeparser.CsharpCodeParser;
import com.natipo.leetcode.core.codeparser.JavaCodeParser;
import com.natipo.leetcode.core.codeparser.JavaScriptCodeParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {

    @Value("${leetcode.output.lang}")
    CodeLang lang;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.defaultHeader("User-Agent", "").build();
    }

    @Bean
    public CodeParser codeParser() {
        switch (lang) {
            case JAVASCRIPT:
                return new JavaScriptCodeParser();
            case CSHARP:
                return new CsharpCodeParser();
            default:
                return new JavaCodeParser();
        }
    }
}
