package com.kb.openAPI.dto;

import lombok.Data;
import org.aspectj.bridge.Message;

import java.util.List;

@Data
public class OpenApiResponseDTO {
    private List<Choice> choices;

    @Data
    public static class Choice {
        private Message message;
    }

    @Data
    public static class Message {
        private String role;
        private String content;
    }
}
