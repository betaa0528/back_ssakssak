package com.kb.alarm.mapper;

import com.kb.alarm.dto.Alarm;
import com.kb.alarm.dto.AlarmResponse;

import java.util.List;

public interface AlarmMapper {
//    List<Alarm> selectAllByStudentId(long stdId, long tchId);
    void insertAlarm(Alarm alarm);

    List<Alarm> selectAllAlarmListByTeacherId(long tchId);

    int updateAlarmIsChecked(long id);
}
