package com.kb.quizRecord.service;

import com.kb.quizRecord.dto.QuizRecordDTO;
import com.kb.quizRecord.dto.StudentRankingDTO;
import com.kb.quizRecord.mapper.QuizRecordMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
@PropertySource({"classpath:/application.yml"})
public class QuizRecordService {

    private final QuizRecordMapper quizRecordMapper;

    public QuizRecordDTO createQuizRecord(QuizRecordDTO quizRecordDTO) {
        quizRecordMapper.insertQuizRecord(quizRecordDTO);  // DB에 퀴즈 기록 저장 후 자동 생성된 qrId도 매핑됨
        return quizRecordDTO;  // 삽입된 데이터 반환
    }
    public List<StudentRankingDTO> getStudentCorrectAnswerRankings() {
        return quizRecordMapper.getStudentCorrectAnswerRankings();
    }
}