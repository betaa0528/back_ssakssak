package com.kb.teacher.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Teacher {
    private long tchId;
    private String tchName;
    private String tchEmail;
    private String tchAccount;
    private String tchPw;
    private int grade;
    private String group;
}
