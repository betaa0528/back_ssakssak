package com.kb.teacher.dto;

import lombok.Data;

@Data
public class TeacherDTO {
    private Long tchId;
    private String tchName;
    private String tchEmail;
    private String tchAccount;
    private String tchPw;
    private Integer grade;
    private String room;
}