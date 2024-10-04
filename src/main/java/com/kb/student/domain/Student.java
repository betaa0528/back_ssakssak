package com.kb.student.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Student {
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
