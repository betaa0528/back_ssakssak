package com.kb.student;

import com.kb.common.exception.SsakssakApplicationException;
import com.kb.student.domain.Student;
import com.kb.student.domain.StudentTransactionHistory;
import com.kb.student.dto.TransactionReason;
import com.kb.student.dto.TransactionType;
import com.kb.student.mapper.StudentMapper;
import com.kb.student.mapper.StudentTransactionHistoryMapper;
import com.kb.student.service.StudentTransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class TransactionTest {

    private static final Logger log = LoggerFactory.getLogger(TransactionTest.class);
    @Mock
    private StudentTransactionHistoryMapper studentTransactionHistoryMapper;

    @Mock
    private StudentMapper studentMapper;

    @InjectMocks
    private StudentTransactionService service;

    private Student mockStudent(long stdId) {
        return Student.builder().stdId(stdId).stdName("test" + stdId).build();
    }

    private StudentTransactionHistory mockStudentTransactionHistory(long id, long stdId, int amount, TransactionType type, TransactionReason reason) {
        return new StudentTransactionHistory(id, stdId, amount, type, reason, LocalDateTime.now());
    }

    private StudentTransactionHistory mockStudentTransactionHistory(long id, long stdId, int amount, TransactionType type, TransactionReason reason, LocalDateTime transactionAt) {
        return new StudentTransactionHistory(id, stdId, amount, type, reason, transactionAt);
    }

    private List<StudentTransactionHistory> createSimpleHistoryList() {
        return List.of(
                mockStudentTransactionHistory(0L, 1L, 1000, TransactionType.INCOME, TransactionReason.WEEKLY_SALARY),
                mockStudentTransactionHistory(1L, 1L, 1000, TransactionType.INCOME, TransactionReason.WEEKLY_SALARY),
                mockStudentTransactionHistory(2L, 1L, 2000, TransactionType.EXPENSE, TransactionReason.STOCK_BUY)
        );
    }

    @Test
    void 학생수입지출_기록이_정상적으로_등록됨() {
        List<StudentTransactionHistory> historyList = createSimpleHistoryList();
        historyList.forEach(h -> when(studentMapper.selectStudentById(h.getStdId())).thenReturn(mockStudent(h.getStdId())));

        // when


        when(studentTransactionHistoryMapper.selectTransactionHistoryByStdId(1L)).thenReturn(historyList);
        historyList.forEach(history -> service.recordInput(history));

        // then
        verify(studentTransactionHistoryMapper, times(3)).insertTransactionHistory(any());
    }

    @Test
    void 수입의_값이_0보다_작으면_예외발생() {
        StudentTransactionHistory history1 = new StudentTransactionHistory(0L, 1L, 0, TransactionType.INCOME, TransactionReason.WEEKLY_SALARY,LocalDateTime.now());


        when(studentMapper.selectStudentById(history1.getStdId())).thenReturn(mockStudent(history1.getStdId()));

        assertThatThrownBy(() -> service.recordInput(history1))
                .isInstanceOf(SsakssakApplicationException.class)
                .hasMessage("잘못된 수입/지출 금액 입력");
    }

    @Test
    void 학생ID가_유효하지않은경우_예외발생() {
        StudentTransactionHistory history1 = new StudentTransactionHistory(0L, -1L, 0, TransactionType.INCOME, TransactionReason.WEEKLY_SALARY, LocalDateTime.now());

        when(studentMapper.selectStudentById(history1.getStdId())).thenReturn(null);

        assertThatThrownBy(() -> service.recordInput(history1))
                .isInstanceOf(SsakssakApplicationException.class)
                .hasMessage("유효하지 않은 학생 ID 입니다.");
    }

    @Test
    void 해당학생의_전체기록을_반환() {
        List<StudentTransactionHistory> historyList = createSimpleHistoryList();
        historyList.forEach(h -> when(studentMapper.selectStudentById(h.getStdId())).thenReturn(mockStudent(h.getStdId())));
        when(studentTransactionHistoryMapper.selectTransactionHistoryByStdId(1L)).thenReturn(historyList);

        List<StudentTransactionHistory> list = service.getHistoryByStdId(1L);

        assertEquals(3, list.size());
    }

    @Test
    void 학생의_수입기록만을_불러옴() {
        List<StudentTransactionHistory> historyList = createSimpleHistoryList();
        historyList.forEach(h -> when(studentMapper.selectStudentById(h.getStdId())).thenReturn(mockStudent(h.getStdId())));
        when(studentTransactionHistoryMapper.selectTransactionHistoryByStdIdAndType(1L, TransactionType.INCOME)).thenReturn(List.of(historyList.get(0), historyList.get(1)));

        List<StudentTransactionHistory> list = service.getHistoryByStdIdAndType(1L, TransactionType.INCOME);
        assertEquals(2, list.size());
        list.forEach(h -> assertEquals(TransactionType.INCOME, historyList.get(0).getType()));
    }

}
