package com.kb.alarm.dto;

import com.kb.student.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Alarm {
    private long id;
    private Student student;
    private String type;
    private long productId;
    private String targetUserName;
    private char isChecked;
    private char sent;
}
