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
    private long stdId;
    private long tchId;
    private long savingId;
    private String savingName;
    private int rate;
    private int depositAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private int totalAmount;
}
