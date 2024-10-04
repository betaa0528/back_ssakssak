package com.kb.quizRecord.mapper;

import com.kb.quizRecord.dto.QuizRecordDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuizRecordMapper {
    void insertQuizRecord(QuizRecordDTO QuizRecordDTO);
}