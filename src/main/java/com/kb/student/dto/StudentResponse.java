package com.kb.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private long stdId;
    private long tchId;
    private int stdNum;
    private String stdName;
    private String stdBirth;
    private long jobId;
    private int seed;
}
