package com.kb.quiz.domain;

import com.kb.quiz.dto.QuizResponse;
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

    public static Quiz toResponse(QuizResponse quizResponse) {
        Quiz quiz = new Quiz();
        quiz.setQuizContent(quizResponse.getQuestion());
        quiz.setAnswer1(quizResponse.getAnswer1());
        quiz.setAnswer2(quizResponse.getAnswer2());
        quiz.setAnswer3(quizResponse.getAnswer3());
        quiz.setAnswer4(quizResponse.getAnswer4());
        quiz.setAnswerNum(quizResponse.getAnswerNum().charAt(0));
        return quiz;
    }
}
