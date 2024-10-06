package com.kb.alarm.mapper;

import com.kb.alarm.dto.Alarm;

import java.util.List;

public interface AlarmMapper {
    List<Alarm> selectAllByStudentId(long stdId, long tchId);
    void insertAlarm(Alarm alarm);
}
