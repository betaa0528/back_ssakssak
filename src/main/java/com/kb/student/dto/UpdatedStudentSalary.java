package com.kb.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatedStudentSalary {
    private Long stdId;
    private Long salaryId;
    private int baseSalary;
    private int additionalSalary;

}
