package com.kb.savingAccount.dto;

import com.kb.saving.domain.Saving;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SavingAccountDTO {
    private Long stdId;
    private Long tchId;
    private Long savingId;
    private Integer rate;
    private Integer depositAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer totalAmount;
}
