package com.kb.quizRecord.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizRecordDTO {
    private long qrId;
    private long quizId;
    private long stdId;
    private String isCorrect;
}
