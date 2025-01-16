package com.kb.salary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryBatchRequest {
    private Long stdId;
    private Long tchId;
    private Long salaryId;
    private int baseSalary;
    private int additionalSalary;
}
