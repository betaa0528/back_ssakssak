package com.kb.alarm.dto;

import com.kb.student.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Alarm {
    private int id;
    private Student student;
    private String type;
    private Long targetId;
}
