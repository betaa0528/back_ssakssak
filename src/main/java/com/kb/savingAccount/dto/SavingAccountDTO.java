package com.kb.savingAccount.dto;

import com.kb.saving.domain.Saving;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SavingAccountDTO {
    private Long accountId;
    private Long stdId;  // 학생 ID
    private Long tchId;  // 선생님 ID
    private Long savingId;  // 적금 ID
    private Integer rate;  // 이자율
    private Integer depositAmount;  // 예치금
    private LocalDateTime startDate;  // 시작 날짜
    private LocalDateTime endDate;  // 종료 날짜
    private String status;  // 상태 ('Y', 'N' 등)
    private Integer totalAmount;  // 총 금액
}
