package com.kb.student.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentCsvDTO {
    private int stdNum;
    private String stdName;
    private String stdBirth;
    private long jobId;
    private int seed;
    private long tchId;
}
