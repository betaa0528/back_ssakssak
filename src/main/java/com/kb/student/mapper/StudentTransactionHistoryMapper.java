package com.kb.student.mapper;

import com.kb.student.domain.StudentTransactionHistory;
import com.kb.student.dto.TransactionType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentTransactionHistoryMapper {
    int insertTransactionHistory(StudentTransactionHistory history);

    List<StudentTransactionHistory> selectTransactionHistoryByStdId(Long stdId);

    List<StudentTransactionHistory> selectTransactionHistoryByStdIdAndType(Long stdId, TransactionType type);
}
