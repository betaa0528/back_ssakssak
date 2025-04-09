package com.kb.student.domain;

import com.kb.student.dto.TransactionReason;
import com.kb.student.dto.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentTransactionHistory {
    private Long id;
    private Long stdId;
    private int amount;
    private TransactionType type;
    private TransactionReason reason;
    private LocalDateTime transactionAt;  // 👈 수입/지출 발생 시점
}
