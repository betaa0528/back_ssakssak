package com.kb.student.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class StudentDTO {
    private long stdId;
    private long tchId;
    private int stdNum;
    private String stdName;
    private String stdAccount;
    private String stdPw;
    private String stdBirth;
    private long jobId;
    private int seed;

    private List<DailyCheckDTO> recentAttendance;  // 필드가 존재해야 함
}