package com.kb.alarm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface AlarmArgs {
    AlarmType getAlarmType();
    String getProductName();
}
