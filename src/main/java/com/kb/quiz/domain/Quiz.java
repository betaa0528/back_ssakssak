package com.kb.quiz.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Quiz {
    private long quizId;
    private String quizContent;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private char answerNum;
    private Date quizDate;
}
