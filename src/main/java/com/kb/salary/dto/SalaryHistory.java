package com.kb.salary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalaryHistory {
    private long historyId;
    private long stdId;
    private long salaryId;
    private int paidAmount;
    private LocalDateTime paidDate;
}
