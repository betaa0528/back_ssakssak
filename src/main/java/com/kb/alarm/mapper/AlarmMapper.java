package com.kb.alarm.mapper;

import com.kb.alarm.dto.Alarm;
import com.kb.alarm.dto.AlarmResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlarmMapper {
//    List<Alarm> selectAllByStudentId(long stdId, long tchId);
    void insertAlarm(Alarm alarm);
    int updateAlarmSent(Alarm alarm);

    List<Alarm> selectAllAlarmListByTeacherId(long tchId);

    int updateAlarmIsChecked(long id);
}
