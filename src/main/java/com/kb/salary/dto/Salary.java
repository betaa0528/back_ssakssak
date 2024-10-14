package com.kb.salary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Salary {
    private long salaryId;
    private int baseSalary;
    private int additionalSalary;
    private LocalDateTime createdAt;
}
