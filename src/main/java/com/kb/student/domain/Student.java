package com.kb.student.domain;

import com.kb.student.dto.StudentDTO;
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

    public static Student of(StudentDTO studentDTO) {
        return Student.builder()
                .stdId(studentDTO.getStdId())
                .tchId(studentDTO.getTchId())
                .stdNum(studentDTO.getStdNum())
                .stdName(studentDTO.getStdName())
                .stdAccount(studentDTO.getStdAccount())
                .stdPw(studentDTO.getStdPw())
                .stdBirth(studentDTO.getStdBirth())
                .jobId(studentDTO.getJobId())
                .stdSeed(studentDTO.getSeed())
                .build();


    }
}
