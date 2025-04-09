package com.kb.student.service;

import com.kb.common.exception.ErrorCode;
import com.kb.common.exception.SsakssakApplicationException;
import com.kb.student.domain.Student;
import com.kb.student.domain.StudentTransactionHistory;
import com.kb.student.dto.TransactionReason;
import com.kb.student.dto.TransactionType;
import com.kb.student.mapper.StudentMapper;
import com.kb.student.mapper.StudentTransactionHistoryMapper;

import java.util.ArrayList;
import java.util.List;

public class StudentTransactionService {

    private StudentTransactionHistoryMapper mapper;
    private StudentMapper studentMapper;

    public void recordInput(StudentTransactionHistory history) {
        Student student = studentMapper.selectStudentById(history.getStdId());
        if(student == null) {
            throw new SsakssakApplicationException(ErrorCode.USER_NOT_FOUND);
        }

        if(history.getAmount() <= 0) {
            throw new SsakssakApplicationException(ErrorCode.INSUFFICIENT_AMOUNT);
        }
        mapper.insertTransactionHistory(history);
    }

    public List<StudentTransactionHistory> getHistoryByStdId(Long stdId) {
        return mapper.selectTransactionHistoryByStdId(stdId);
    }

    public List<StudentTransactionHistory> getHistoryByStdIdAndType(Long stdId, TransactionType type) {
        return mapper.selectTransactionHistoryByStdIdAndType(stdId, type);
    }


}
