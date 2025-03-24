package com.kb.alarm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlarmEvent {
    private Long stdId;
    private AlarmArgs alarmArgs;
    private Long productId;
    private LocalDateTime sentAt;
}
