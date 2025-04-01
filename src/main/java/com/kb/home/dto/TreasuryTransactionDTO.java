package com.kb.home.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreasuryTransactionDTO {
    private long transactionId;
    private int amount;                   // 수익 또는 지출 금액
    private String transactionType;       // 'INCOME' or 'EXPENSE' 수익 혹은 지출
    private String source;                // 'TAX', 'COUPON_SALE', 'REWARD', 'SALARY' 등
    private String description;           // 거래 설명
    private LocalDateTime transactionDate; // 거래 발생 일자
}
