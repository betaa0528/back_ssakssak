package com.kb.student.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private long stdId;
    private long tchId;
    private int stdNum;
    private String stdName;
    private String stdAccount;
    private String stdPw;
    private String stdBirth;
    private long jobId;
    private int stdSeed;
}