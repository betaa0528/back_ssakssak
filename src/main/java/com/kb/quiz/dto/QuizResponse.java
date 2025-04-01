package com.kb.quiz.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizResponse {
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answerNum;
}
