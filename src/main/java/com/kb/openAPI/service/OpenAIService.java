package com.kb.openAPI.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenAIService {

    private final String API_URL = "https://api.openai.com/v1/chat/completions";
    @Value("${chat-gpt.api-key}")
    private String API_KEY;

    public String generateQuiz(String prompt) {
        RestTemplate restTemplate = new RestTemplate();

        // HTTP 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);
        headers.set("Content-Type", "application/json");

        // 요청 본문 설정
        String body = """
        {
          "model": "gpt-4o-mini",
          "messages": [
            {"role": "system", "content": "당신은 초등학교 수준의 퀴즈를 전문적으로 만드는 전문가 입니다. 초등학생이 풀기 쉬운 객관식 문제를 만들어주세요. 네 개의 보기(A, B, C, D)가 포함되어 있어야 하며, 문제는 초등학생(7-12세) 수준에 맞춰 주세요. 파싱하기 쉬운 JSON.{\\\\\\"question\\\\\\": \\\\\\"...\\\\\\", \\\\\\"answer1\\\\\\": \\\\\\"...\\\\\\", \\\\\\"answer2\\\\\\": \\\\\\"...\\\\\\", \\\\\\"answer3\\\\\\": \\\\\\"...\\\\\\", \\\\\\"answer4\\\\\\": \\\\\\"...\\\\\\", \\\\\\"answerNum\\\\\\": \\\\\\"...\\\\\\"}."},
            {"role": "user", "content": "%s"}
          ],
          "max_tokens": 400
        }
        """.formatted(prompt);

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        // API 호출
        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.POST, entity, String.class);
        return response.getBody(); // JSON 형태 응답 반환
    }

}
