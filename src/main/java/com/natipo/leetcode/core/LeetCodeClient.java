package com.natipo.leetcode.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LeetCodeClient {

    private final RestTemplate restTemplate;

    @Value("${leetcode.url}")
    private String url;

    @Autowired
    public LeetCodeClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> ResponseEntity<T> getResponse(Object request, Class<T> responseType) {
        return restTemplate.postForEntity(url, request, responseType);
    }
}
