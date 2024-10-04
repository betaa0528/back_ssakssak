package com.kb.quizRecord.service;

import com.kb.quizRecord.dto.QuizRecordDTO;
import com.kb.quizRecord.mapper.QuizRecordMapper;
import com.kb.savingAccount.dto.SavingAccountDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Log4j
@Service
@RequiredArgsConstructor
@PropertySource({"classpath:/application.properties"})
public class QuizRecordService {

    private final QuizRecordMapper mapper;

    public QuizRecordDTO createQuizRecord(QuizRecordDTO QuizRecordDTO) {
        mapper.insertQuizRecord(QuizRecordDTO);  // DB에 퀴즈 기록 저장
        return QuizRecordDTO;
    }
}