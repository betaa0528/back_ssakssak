package com.kb.quizRecord.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class QuizRecord {
    private long qrId;
    private long quizId;
    private char isCorrect;
    private long stdId;
}
