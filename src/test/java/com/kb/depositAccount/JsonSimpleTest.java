package com.kb.depositAccount;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.kb.quiz.domain.Quiz;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonSimpleTest {

    private String content = "```json\n{\n  \"question\": \"화폐의 주된 역할 중 하나는 무엇인가요?\",\n  \"answer1\": \"사람들이 여행을 갈 때 필요한 물건\",\n  \"answer2\": \"상품과 서비스를 사고팔 때 사용하는 거래 수단\",\n  \"answer3\": \"모든 것을 무료로 나누는 방법\",\n  \"answer4\": \"사람들이 친구와 놀 때 쓰는 장난감\",\n  \"answerNum\": \"2\"\n}\n```";

    @Test
    public void JsonTest() {
        Gson gson = new Gson();
        String replace = content.replace("```", "");
        String json = replace.replace("json", "");
        System.out.println(json);
        Quiz quiz = gson.fromJson(json, Quiz.class);

        System.out.println(quiz);


    }

    @Test
    public void 포맷테스트() {
        String pre = "PRE";
        long id = 1L;
        LocalDate now = LocalDate.now();
        String key = String.format("%s:%d:%s", pre, id, now);
        System.out.println(key);
    }


}
